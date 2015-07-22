package com.igor2i.lesson3;

/**
 * Created by igor2i on 21.07.15.
 */
public class Messag {
    private String from;
    private String to;

    @MessagInfo(lang = LangType.En, maxLanght = 500)
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
