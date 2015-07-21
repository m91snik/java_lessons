package com.m91snik.arrayetc;

/**
 * Created by Valentin on 21.07.2015.
 */
public class Message {

    private String from;
    private String to;

    @MaxLengh(2048)
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
