package com.lexsus.chat;

import com.lexsus.chat.consumer.BaseConsumer;
import com.lexsus.chat.consumer.Consumer;
import com.lexsus.chat.consumer.ConsumerException;
import com.lexsus.chat.generator.StringMessageGenerator;
import com.lexsus.chat.processor.StringMessageProcessor;
import com.lexsus.chat.producer.BaseProducer;
import com.lexsus.chat.producer.Producer;
import com.lexsus.chat.producer.ProducerException;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public class StringMessageSystem {

    SharedQueue<String> sharedQueue = new SharedQueue<>();

    Consumer<String> consumer = new BaseConsumer<>(sharedQueue, new StringMessageProcessor());
    Producer<String> producer = new BaseProducer<>(sharedQueue, new StringMessageGenerator());

    boolean isStopped = false;

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
                    producer.produce(null);
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
