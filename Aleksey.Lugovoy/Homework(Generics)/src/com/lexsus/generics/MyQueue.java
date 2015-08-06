package com.lexsus.generics;

/**
 * Created by LugovoyAV on 06.08.2015.
 */
public interface MyQueue<T> {
    void enqueue(T o1);
    T dequeue();
    T peek();
    int size();
}
