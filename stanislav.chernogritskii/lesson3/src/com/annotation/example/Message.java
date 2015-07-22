package com.annotation.example;

/**
 * Created by stanislav on 21.07.15.
 */
public class Message {

    private String from;
    private String to;

    @MaxLength(2048)
    private String text;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
