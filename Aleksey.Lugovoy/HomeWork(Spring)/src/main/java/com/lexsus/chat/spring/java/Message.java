package com.lexsus.chat.spring.java;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lexsus on 19.08.2015.
 */
public class Message implements Serializable{

    public MessageType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text +
                '}';
    }

    public String getAdditional() {
        return additional;
    }

    public Message(MessageType type, String text,String additional) {
        this.type = type;
        this.text = text;
        this.additional = additional;
    }

    final String text;
    final String additional;
    Date date;
    final MessageType type;
}
