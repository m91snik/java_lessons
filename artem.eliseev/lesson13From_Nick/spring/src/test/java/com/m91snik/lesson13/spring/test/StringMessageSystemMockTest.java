package com.m91snik.lesson13.spring.test;

import com.m91snik.lesson13.SharedQueue;
import com.m91snik.lesson13.consumer.BaseConsumer;
import com.m91snik.lesson13.consumer.Consumer;
import com.m91snik.lesson13.generator.MessageGenerator;
import com.m91snik.lesson13.processor.MessageProcessor;
import com.m91snik.lesson13.producer.BaseProducer;
import com.m91snik.lesson13.producer.Producer;
import com.m91snik.lesson13.spring.xml.StringMessageSystem;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public class StringMessageSystemMockTest {

    private StringMessageSystem stringMessageSystem;

    private MessageGenerator<String> generator;
    private MessageProcessor<String> processor;


    @Before
    public void setup() {

        generator = Mockito.mock(MessageGenerator.class);
        processor = Mockito.mock(MessageProcessor.class);

        SharedQueue<String> sharedQueue = new SharedQueue<>();
        Producer<String> producer = new BaseProducer<>(sharedQueue, generator);
        Consumer<String> consumer = new BaseConsumer<>(sharedQueue, processor);

        stringMessageSystem = new StringMessageSystem(consumer, producer);
    }

    @Test
    public void testMessageSystem() {
        Mockito.when(generator.generate()).thenReturn("mockito");

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

        Mockito.verify(processor,Mockito.atLeastOnce()).process("mockito");

    }
}
