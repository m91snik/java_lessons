package com.m91snik.lesson13;

import com.m91snik.lesson13.consumer.BaseConsumer;
import com.m91snik.lesson13.consumer.Consumer;
import com.m91snik.lesson13.consumer.ConsumerException;
import com.m91snik.lesson13.generator.StringMessageGenerator;
import com.m91snik.lesson13.processor.StringMessageProcessor;
import com.m91snik.lesson13.producer.BaseProducer;
import com.m91snik.lesson13.producer.Producer;
import com.m91snik.lesson13.producer.ProducerException;

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
