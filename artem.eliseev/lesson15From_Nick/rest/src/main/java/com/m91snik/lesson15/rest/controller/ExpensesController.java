package com.m91snik.lesson15.rest.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.m91snik.lesson15.rest.dto.Expenses;
import com.m91snik.lesson15.rest.entity.UserType;
import com.m91snik.lesson15.rest.service.ExpensesService;
import com.m91snik.lesson15.rest.service.UserService;
import freemarker.template.TemplateException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
@RequestMapping(value = "/controller/expenses")
public class ExpensesController {

    private static final Logger LOGGER = Logger.getLogger(ExpensesController.class);

    @Autowired
    private ExpensesService expensesService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Expenses create(@RequestBody Expenses expenses) {
        return expensesService.create(expenses);
    }

    @RequestMapping(value = "/{expensesId}", method = RequestMethod.PUT)
    @ResponseBody
    public Expenses update(@RequestBody Expenses expenses) {
        return expensesService.update(expenses);
    }

    @RequestMapping(value = "/{expensesId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("expensesId") String expenseId) {
        expensesService.remove(expenseId);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public final Collection<Expenses> list(@RequestParam("ownerId") String ownerId,
                                           @RequestParam(value = "from", required = false) String from,
                                           @RequestParam(value = "to", required = false) String to) throws ParseException {
        if (ownerId == null) {
            throw new IllegalArgumentException("OwnerId is mandatory");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        GrantedAuthority authority = authentication.getAuthorities().iterator().next();
        if ((authority.getAuthority().equals("ROLE_" + UserType.REGULAR) ||
                authority.getAuthority().equals("ROLE_" + UserType.MANAGER))
                && !ownerId.equals(authentication.getPrincipal())) {
            throw new IllegalArgumentException("Owner is not logged in");
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date fromDate = from == null ? null : simpleDateFormat.parse(from);
        Date toDate = to == null ? null : simpleDateFormat.parse(to);

        return expensesService.getExpenses(ownerId, fromDate, toDate);
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<InputStreamResource> report(@RequestParam("ownerId") String ownerId,
                                                      @RequestParam(value = "from", required = false) String from,
                                                      @RequestParam(value = "to", required = false) String to)
            throws ParseException, IOException, TemplateException, SAXException, ParserConfigurationException, DocumentException {
        Collection<Expenses> expenses = list(ownerId, from, to);
        String report = expensesService.generateReport(expenses);

        Document pdfDoc = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PdfWriter pdfWriter = PdfWriter.getInstance(pdfDoc, byteArrayOutputStream);

        pdfDoc.open();
        pdfDoc.setMarginMirroring(true);
        pdfDoc.setMargins(36, 72, 108, 180);
        pdfDoc.topMargin();
        Font myfont = new Font();
        Font bold_font = new Font();
        bold_font.setStyle(Font.BOLD);
        bold_font.setSize(10);
        myfont.setStyle(Font.NORMAL);
        myfont.setSize(10);
        pdfDoc.add(new Paragraph(report));

        pdfDoc.close();
        pdfWriter.close();


        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentType(MediaType.parseMediaType("application/pdf"));
        respHeaders.setContentDispositionFormData("attachment", "expenses.pdf");
        InputStreamResource isr = new InputStreamResource(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        return new ResponseEntity<>(isr, respHeaders, HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleClientErrors(Exception ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleServerErrors(Exception ex) {
        LOGGER.error(ex);
        return "An internal server error occured:" + ex.getMessage();
    }
}
