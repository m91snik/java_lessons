package com.makedonsky94.socket;

import java.net.Socket;

/**
 * Created by user on 13.08.2015.
 */
public class Message {
    public Message(String messageString, Socket client, String color, String nick) {
        this.messageString = messageString;
        this.client = client;
        this.color = color;
        this.nick = nick;
    }

    private String messageString;
    private Socket client;
    private String color;
    private String nick;

    public String getMessageString() {
        return messageString;
    }

    public Socket getClient() {
        return client;
    }

    public String getColor() {
        return color;
    }

    public String getNick() { return nick; }

}
