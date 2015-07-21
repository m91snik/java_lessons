package com.julia.lesson;

/**
 * Created by User on 21.07.2015.
 */
public class Message {

    private String from;
    private String to;

    @MessageInfo(lang = LangType.DE, maxLenght = 2048)
    private String text;
}
