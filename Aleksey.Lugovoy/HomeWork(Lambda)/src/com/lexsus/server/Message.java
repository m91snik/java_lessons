package com.lexsus.server;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lexsus on 19.08.2015.
 */
public class Message implements Serializable{
    public MessageType type;

    public Message(MessageType type, String text) {
        this.type = type;
        Text = text;
    }

    public String Text;
    public String Additional;
    public Date date;
}
