package com.m91snik.lesson13.spring.test;

import com.m91snik.lesson13.spring.stub.AssertionProcessor;
import com.m91snik.lesson13.spring.xml.StringMessageSystem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
@ContextConfiguration("classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StringMessageSystemStubTest {

    @Autowired
    StringMessageSystem stringMessageSystem;
    @Autowired
    AssertionProcessor assertionProcessor;

    @Test
    public void testMessageSystem() {
        stringMessageSystem.runMessagesSystem();

        long currentTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - currentTime < 2000) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stringMessageSystem.setStopped(true);

        Assert.assertNull(assertionProcessor.getAssertionError());
        Assert.assertTrue(assertionProcessor.isProcessed());

    }
}
