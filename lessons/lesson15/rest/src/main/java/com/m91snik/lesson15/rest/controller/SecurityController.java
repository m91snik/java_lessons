package com.m91snik.lesson15.rest.controller;

import com.m91snik.lesson15.rest.entity.UserType;
import com.m91snik.lesson15.rest.security.CustomAuthenticationProvider;
import com.m91snik.lesson15.rest.dto.User;
import com.m91snik.lesson15.rest.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/")
public class SecurityController {

    private static final Logger LOGGER = Logger.getLogger(SecurityController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private CustomAuthenticationProvider authenticationProvider;


    @RequestMapping(method = RequestMethod.GET)
    public String defaultPage() {
        return "redirect:/login.html";
    }

    @RequestMapping(value = "/loggin", method = RequestMethod.GET)
    public String loggin() {
        return "redirect:/login.html";
    }

    @RequestMapping(value = "/logged_in")
    public String afterLogin(HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.find((String) authentication.getPrincipal());


        if (user.getUserType() == UserType.REGULAR) {
            response.addCookie(new Cookie("user_id", user.getId() + ""));
            response.addCookie(new Cookie("user_name", user.getName()));
            return "redirect:/expenses.html";
        } else {
            response.addCookie(new Cookie("admin_id", user.getId() + ""));
            response.addCookie(new Cookie("admin_name", user.getName()));
            response.addCookie(new Cookie("user_type", user.getUserType().toString()));
            return "redirect:/users.html";
        }
    }

    @RequestMapping(value = "do_register", method = RequestMethod.POST)
    public String create(HttpServletResponse response, @RequestParam(value = "username") String username
            , @RequestParam("password") String password
            , @RequestParam("confirmPassword") String confirmPassword) {

        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("password and confirm password should be the same");
        }
        User createdUser = userService.create(username, password, UserType.REGULAR);

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationProvider.authenticate(authentication);

        SecurityContextHolder.getContext().setAuthentication(authenticate);

        response.addCookie(new Cookie("user_id", createdUser.getId() + ""));
        response.addCookie(new Cookie("user_name", createdUser.getName()));
        response.addCookie(new Cookie("user_type", createdUser.getUserType().toString()));

        return "redirect:/expenses.html";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleServerErrors(Exception ex) {
        LOGGER.error(ex);
        return ex.getMessage();
    }
}
