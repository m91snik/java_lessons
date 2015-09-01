package com.m91snik.lesson13.spring.stub;

import com.m91snik.lesson13.processor.MessageProcessor;
import org.junit.Assert;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public class AssertionProcessor implements MessageProcessor<String> {

    AssertionError assertionError;


    @Override
    public void process(String element) {
        try {
            Assert.assertEquals("stub", element);
        } catch (AssertionError e) {
            assertionError = e;
            throw e;
        }
    }

    public AssertionError getAssertionError() {
        return assertionError;
    }
}
