package com.lexsus.chat.generator;

import com.lexsus.chat.base.LaggedUserService;

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
