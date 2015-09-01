package com.lexsus.chat.consumer;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public interface Consumer<E> {

    public void consume() throws ConsumerException;
}
