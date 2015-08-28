package com.m91snik.lesson13.producer;

import com.m91snik.lesson13.SharedQueue;
import com.m91snik.lesson13.generator.MessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
//@Component
public class BaseProducer<E> implements Producer<E> {

    @Autowired
    private SharedQueue<E> sharedQueue;

    @Autowired
    MessageGenerator<E> generator;

    public BaseProducer() {
    }

    public BaseProducer(SharedQueue<E> sharedQueue, MessageGenerator<E> generator) {
        this.sharedQueue = sharedQueue;
        this.generator = generator;
    }

    @Override
    public void produce() throws ProducerException {
        try {
            sharedQueue.put(generator.generate());
        } catch (InterruptedException e) {
            throw new ProducerException(e);
        }
    }
}
