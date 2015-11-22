package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ната и Артем on 22.11.2015.
 */
@Controller
@RequestMapping(value = "/")
public class SecurityController {
    @RequestMapping(method = RequestMethod.GET)
    public String defaultPage() {
        return "redirect:/404.html";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String page404 () {
        return "redirect:/404.html";
    }
}
