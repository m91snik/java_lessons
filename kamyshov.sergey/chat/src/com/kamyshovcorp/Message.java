package com.kamyshovcorp;

import java.io.Serializable;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String text;
    private ClientInfo clientInfo;

    public Message(String text, ClientInfo clientInfo) {
        this.text = text;
        this.clientInfo = clientInfo;
    }

    public String getText() {
        return text;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }
}
