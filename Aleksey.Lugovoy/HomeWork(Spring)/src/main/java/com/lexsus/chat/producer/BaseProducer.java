package com.lexsus.chat.producer;

import com.lexsus.chat.SharedQueue;
import com.lexsus.chat.base.LaggedUserService;
import com.lexsus.chat.generator.MessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
//@Component
public class BaseProducer<E> implements Producer<E> {

    @Autowired
    protected SharedQueue<E> sharedQueue;

    @Autowired
    MessageGenerator<E> generator;

    public BaseProducer() {
    }

    public BaseProducer(SharedQueue<E> sharedQueue, MessageGenerator<E> generator) {
        this.sharedQueue = sharedQueue;
        this.generator = generator;
    }

    @Override
    public void produce(LaggedUserService service) throws ProducerException {
        try {
            sharedQueue.put(generator.generate(null));
        } catch (InterruptedException e) {
            throw new ProducerException(e);
        }
    }
}