package com.example.oop;

/**
 * Created by stanislav on 30.07.15.
 */
public class Array implements Collection<Integer> {

    private Integer[] array;
    private int size;

    public Array() {
        array = new Integer[10];
    }

    public Array(int i) {
        array = new Integer[i];
    }

    @Override
    public boolean create(Integer i) {
        int num = size++;
        array[num] = (i + 1) * 10;

        return true;
    }

    @Override
    public Integer[] read() {
        return array;
    }

    @Override
    public Integer[] update(Integer i) {
        array[i] = 777;
        return array;
    }

    @Override
    public Integer[] delete(Integer i) {
        array[i] = 0;
        return array;
    }
}
