package com.m91snik.lesson15.rest.service;

import com.m91snik.lesson15.rest.dto.User;
import com.m91snik.lesson15.rest.entity.UserType;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User create(String name, String password, UserType userType);

    List<User> getUsers();

    User findByNameAndPassword(String name, String password);

    User findByName(String name);

    User find(String userId);

    void remove(String userId);

    User update(User user);
}
