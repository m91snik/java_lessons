package com.controller;

/**
 * Created by Anry on 23.11.2015.
 */
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping(value="user/list/id/{id}",method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String userList(Model ui, @PathVariable("id") Long id)
    {
        ui.addAttribute("contacts", "Ce contacts"+id.toString());

        return "user/list";
    }

    @RequestMapping(value="user/list/id/{id}", method= RequestMethod.GET,produces="text/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String userListJson(Model ui, @PathVariable("id") Long id)
    {
        return "{id:"+id.toString()+"}";
    }

    @RequestMapping("/")
    public String main(Model ui)
    {
        return "redirect:user/list";
    }
}