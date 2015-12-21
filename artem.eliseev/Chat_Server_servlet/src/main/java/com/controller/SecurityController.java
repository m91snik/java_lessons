package com.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ната и Артем on 22.11.2015.
 */
@Controller
@RequestMapping(value = "/")
public class SecurityController {

    private static final Logger LOGGER = Logger.getLogger(SecurityController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String defaultPage() {
        return "redirect:/404.html";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String page404 () {
        return "redirect:/404.html";
    }
}
