package com.makedonsky94.socket;

/**
 * Created by user on 13.08.2015.
 */
public class Message {
    public Message(String messageString) {
        this.messageString = messageString;
    }
    private String messageString;

    public String getMessageString() {
        return messageString;
    }

}
