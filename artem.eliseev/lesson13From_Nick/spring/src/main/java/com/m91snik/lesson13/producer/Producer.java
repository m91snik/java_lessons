package com.m91snik.lesson13.producer;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public interface Producer<E> {

    public void produce() throws ProducerException;
}
