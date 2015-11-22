package com.frontEnd;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ���� � ����� on 05.10.2015.
 */
@Controller
@RestController
@RequestMapping(value = "/index")
public class FrontEndController extends HttpServlet {

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/index/page")
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello! It's ChatServlet</h1>");
        out.println("</body>");
        out.println("</html>");
        System.out.println("Hello! It's ChatServlet without HTML");
    }

    @RequestMapping("/message")
    public Message message() {
        return new Message("Hello! It's ChatServlet from Message, entered from FrontEndController");
    }

    @RequestMapping("/404.html")
    public String Error404() {
        return "redirect:/404.html";
    }

}
