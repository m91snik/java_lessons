package com.makedonsky94.interfaces;


import java.util.Arrays;

/**
 * Created by Sasha on 30.07.2015.
 */
public class ArrayCollection<E> implements Collection <E> {

    private final int DEFAULT_ARRAY_SIZE = 5;

    Object[] items;
    private int length;
    private int resizeCoeff = 2;

    public ArrayCollection() {
        items = new Object[DEFAULT_ARRAY_SIZE];
    }

    @Override
    public void add(E item) {
        if(length >= items.length - 1) {
            Object[] cacheItems = items.clone();
            items = new Object[items.length * resizeCoeff];
            for(int i = 0; i < cacheItems.length; i++) {
                items[i] = cacheItems[i];
            }
        }
        addItem(item);
    }

    private void addItem(E item) {
        items[length] = item;
        length++;
    }

    @Override
    public E get(int index) {
        if(index > length || index < 0)
            throw new IllegalArgumentException("Index can not be negative and bigger than length");
        return (E)items[index];
    }

    @Override
    public void delete(int index) {
        if(index > length || index < 0)
            throw new IllegalArgumentException("Index can not be negative and bigger than length");
        //TODO: delete item by index
    }

    @Override
    public void delete(E item) {
        //TODO: delete item by value
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        //TODO: crop array
        return Arrays.toString(items);
    }
}
