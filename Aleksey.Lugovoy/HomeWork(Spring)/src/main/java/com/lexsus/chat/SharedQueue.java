package com.lexsus.chat;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
//@Component
public class SharedQueue<E> {

    private final BlockingQueue<E> queue;

    public SharedQueue() {

        this.queue = new LinkedBlockingQueue<>();
    }

    public E take() throws InterruptedException {
        return queue.take();
    }

    public void put(E e) throws InterruptedException {
        queue.put(e);
    }
}
