package com.m91snik.lesson13.processor;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public interface MessageProcessor<E> {
    void process(E message);
}
