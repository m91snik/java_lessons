package com.example.oop;

/**
 * Created by stanislav on 30.07.15.
 */
public interface Collection<T> {

    boolean create(T item);
    T[] read();
    T[] update(T i);
    T[] delete(T i);
}
