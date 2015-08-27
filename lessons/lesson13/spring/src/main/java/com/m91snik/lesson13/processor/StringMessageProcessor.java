package com.m91snik.lesson13.processor;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public class StringMessageProcessor implements MessageProcessor<String> {
    @Override
    public void process(String message) {
        System.out.println(message + "is processed");
    }
}
