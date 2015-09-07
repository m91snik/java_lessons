package com.lexsus.chat;

import com.lexsus.chat.consumer.ConsumerException;
import com.lexsus.chat.consumer.Consumer;
import com.lexsus.chat.producer.Producer;
import com.lexsus.chat.producer.ProducerException;
import com.lexsus.chat.spring.java.Message;

import java.io.IOException;

/**
 * Created by Lexsus on 30.08.2015.
 */
public class ClientMessageSystem {
    Consumer<Message> consumer;
    Producer<Message> producer;

    boolean isStopped = false;

    public ClientMessageSystem(Consumer<Message> consumer, Producer<Message> producer) {
        this.consumer = consumer;
        this.producer = producer;
    }

    public void runMessagesSystem() {
        isStopped = false;
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
                    producer.produce(null);
                    Thread.sleep(1000);
                } catch (ProducerException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    //just ignore it
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void setStopped(boolean isStopped) {
        this.isStopped = isStopped;
    }
}
