package com.lexsus.chat.spring.java;

import com.lexsus.chat.consumer.ConsumerException;
import com.lexsus.chat.consumer.Consumer;
import com.lexsus.chat.producer.Producer;
import com.lexsus.chat.producer.ProducerException;

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
