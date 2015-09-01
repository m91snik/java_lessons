package com.m91snik.lesson13.generator;

import org.springframework.stereotype.Component;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
//@Component
public class StringMessageGenerator implements MessageGenerator<String> {
    @Override
    public String generate() {
        return Math.random() + "";
    }
}
