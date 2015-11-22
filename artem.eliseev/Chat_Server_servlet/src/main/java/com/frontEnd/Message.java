package com.frontEnd;

/**
 * Created by Ната и Артем on 20.11.2015.
 */
public class Message {
    String message = "Hello! It's ChatServlet from Message.";

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
