package com.m91snik.lesson14.jdbc;

import java.sql.Timestamp;

/**
 * Created by m91snik on 30.08.15.
 */
public class User {

    public String id;
    public String name;
    public String password;
    public Timestamp date;

    public User(String id, String name, String password, Timestamp date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                '}';
    }
}
