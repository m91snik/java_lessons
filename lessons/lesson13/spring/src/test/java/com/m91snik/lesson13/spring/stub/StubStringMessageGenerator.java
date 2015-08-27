package com.m91snik.lesson13.spring.stub;

import com.m91snik.lesson13.generator.MessageGenerator;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public class StubStringMessageGenerator implements MessageGenerator<String> {
    @Override
    public String generate() {
        return "stub";
    }
}
