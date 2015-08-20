package com.kamyshovcorp;

import java.io.Serializable;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String text;
    private String hostname;
    private int port;

    public Message(String text, String hostname, int port) {
        this.text = text;
        this.hostname = hostname;
        this.port = port;
    }

    public String getText() {
        return text;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }
}
