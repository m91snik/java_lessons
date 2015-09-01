package com.m91snik.lesson13.spring.java;

import com.m91snik.lesson13.consumer.Consumer;
import com.m91snik.lesson13.consumer.ConsumerException;
import com.m91snik.lesson13.generator.MessageGenerator;
import com.m91snik.lesson13.producer.Producer;
import com.m91snik.lesson13.producer.ProducerException;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public class StringMessageSystem {

    Consumer<String> consumer;
    Producer<String> producer;

    boolean isStopped = false;

    public StringMessageSystem(Consumer<String> consumer, Producer<String> producer) {
        this.consumer = consumer;
        this.producer = producer;
    }

    public void runMessagesSystem() {
        new Thread(() -> {
            while (!isStopped) {
                try {
                    consumer.consume();
                } catch (ConsumerException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (!isStopped) {
                try {
                    producer.produce();
                    Thread.sleep(1000);
                } catch (ProducerException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    //just ignore it
                }
            }
        }).start();
    }

    public void setStopped(boolean isStopped) {
        this.isStopped = isStopped;
    }
}
