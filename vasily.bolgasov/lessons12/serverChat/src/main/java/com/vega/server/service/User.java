package com.vega.server.service;

/**
 * Created by Вася-Вега on 08.09.2015.
 */
public class User {

    public String id;
    public String login;
    public String password;
    public String name;
    public String lastname;

    public User(String id, String login, String password, String name, String lastname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "User{" +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
