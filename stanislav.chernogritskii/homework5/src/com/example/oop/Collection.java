package com.example.oop;

/**
 * Created by stanislav on 30.07.15.
 */
public interface Collection {

    boolean create(Object item);
    Object[] read();
    Object[] update(int i);
    Object[] delete(int i);
}
