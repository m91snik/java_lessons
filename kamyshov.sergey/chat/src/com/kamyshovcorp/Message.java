package com.kamyshovcorp;

import java.io.Serializable;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class Message implements Serializable {

    private String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
