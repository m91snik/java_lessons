package com.m91snik.lesson13.spring.annotation;

import com.m91snik.lesson13.consumer.Consumer;
import com.m91snik.lesson13.consumer.ConsumerException;
import com.m91snik.lesson13.generator.MessageGenerator;
import com.m91snik.lesson13.producer.Producer;
import com.m91snik.lesson13.producer.ProducerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
@Service
public class StringMessageSystem {

    @Autowired
    Consumer<String> consumer;
    @Autowired
    Producer<String> producer;

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
