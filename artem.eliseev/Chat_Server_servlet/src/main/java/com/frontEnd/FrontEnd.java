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
 * Created by Ната и Артем on 05.10.2015.
 */
@Component
@Controller
@RequestMapping(value = "/")
public class FrontEnd extends HttpServlet{
    
    @RequestMapping(method = RequestMethod.GET)
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello! It's ChatServlet</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
