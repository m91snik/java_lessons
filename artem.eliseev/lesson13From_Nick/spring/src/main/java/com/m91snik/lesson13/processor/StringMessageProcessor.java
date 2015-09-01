package com.m91snik.lesson13.processor;

import org.springframework.stereotype.Component;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
//@Component
public class StringMessageProcessor implements MessageProcessor<String> {
    @Override
    public void process(String message) {
        System.out.println(message + "is processed");
    }
}
