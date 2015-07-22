package com.vega.lesson3.leas;

/**
 * Created by Veg'Zul on 21.07.2015.
 */
public class Message {

    private String from;
    private String to;

    @MessageInfo(lang = LangType.EN, maxLenght = 2048)
    private String text;

}
