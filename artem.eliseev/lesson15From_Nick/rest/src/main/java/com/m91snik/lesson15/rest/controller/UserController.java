package com.m91snik.lesson15.rest.controller;

import com.m91snik.lesson15.rest.entity.UserType;
import com.m91snik.lesson15.rest.security.CustomAuthenticationProvider;
import com.m91snik.lesson15.rest.dto.User;
import com.m91snik.lesson15.rest.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping(value = "/controller/user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);


    @Autowired
    private UserService userService;
    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public User create(@RequestParam("adminId") String adminId, @RequestBody User user) {
        User admin = userService.find(adminId);
        validateIfUserHasPermissions(admin);
        return userService.create(user.getName(), user.getPassword(), user.getUserType());
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("userId") String userId) {
        userService.remove(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestParam("adminId") String adminId, @RequestBody User user) {
        User admin = userService.find(adminId);
        validateIfUserHasPermissions(admin);
        userService.update(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<User> list(String userId) {
        User user = userService.find(userId);
        validateIfUserHasPermissions(user);
        return userService.getUsers();
    }

    private void validateIfUserHasPermissions(User user) {
        if (user.getUserType() != UserType.ADMIN && user.getUserType() != UserType.MANAGER) {
            throw new IllegalArgumentException("UserId " + user.getId() + " cannot be used to manage users");
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleServerErrors(Exception ex) {
        LOGGER.error(ex);
        return ex.getMessage();
    }
}
