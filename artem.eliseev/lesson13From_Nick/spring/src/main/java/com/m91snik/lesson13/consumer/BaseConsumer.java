package com.m91snik.lesson13.consumer;

import com.m91snik.lesson13.SharedQueue;
import com.m91snik.lesson13.processor.MessageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
//@Component


public class BaseConsumer<E> implements Consumer<E>{

    @Autowired
    private SharedQueue<E> sharedQueue;
    @Autowired
    private MessageProcessor messageProcessor;

    public BaseConsumer() {
    }

    public BaseConsumer(SharedQueue<E> sharedQueue, MessageProcessor<E> messageProcessor) {
        this.sharedQueue = sharedQueue;
        this.messageProcessor = messageProcessor;
    }

    @Override
    public void consume() throws ConsumerException {
        E element = null;
        try {
            element = sharedQueue.take();
        } catch (InterruptedException e) {
            throw new ConsumerException(e);
        }
        messageProcessor.process(element);
    }

    public SharedQueue<E> getSharedQueue() {
        return sharedQueue;
    }

    public void setSharedQueue(SharedQueue<E> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
}
