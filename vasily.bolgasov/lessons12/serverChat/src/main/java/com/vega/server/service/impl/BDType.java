package com.vega.server.service.impl;

/**
 * Created by Вася-Вега on 09.09.2015.
 */
public enum BDType {
    CONNECTBASE("jdbc:mysql://localhost:3306/chat"),
    FINDQUERY("SELECT * from USER WHERE login = ?"),
    FINDUSER("SELECT * from USER WHERE login = ? AND password = ?"),
    INSERTQUERY("INSERT into USER values (?,?,?,?,?)"),
    USER("root"),
    CHANGEPASSWORD("UPDATE user SET password = ? WHERE login = ? AND password = ?;"),
    CHANGENAME("UPDATE user SET name = ? WHERE login = ? AND password = ?;"),
    CHANGELASTNAME("UPDATE user SET lastname = ? WHERE login = ? AND password = ?;");


    String type;

    BDType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
