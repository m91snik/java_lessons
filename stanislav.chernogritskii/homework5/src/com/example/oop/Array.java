package com.example.oop;

/**
 * Created by stanislav on 30.07.15.
 */
public class Array implements Collection {

    private Object[] array;
    private int size;

    public Array() {
        array = new Object[10];
    }

    public Array(int i) {
        array = new Object[i];
    }

    @Override
    public boolean create(Object i) {
        int num = size++;
        array[num] = ((int)i + 1) * 10;

        return true;
    }

    @Override
    public Object[] read() {
        return array;
    }

    @Override
    public Object[] update(int i) {
        array[i] = 777;
        return array;
    }

    @Override
    public Object[] delete(int i) {
        array[i] = null;
        return array;
    }
}
