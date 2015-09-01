package com.lexsus.chat.consumer;

import com.lexsus.chat.processor.MessageProcessor;
import com.lexsus.chat.SharedQueue;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
//@Component
public class BaseConsumer<E> implements Consumer<E>{

    @Autowired
    private SharedQueue<E> sharedQueue;
    @Autowired
    protected MessageProcessor messageProcessor;

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
