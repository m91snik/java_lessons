package com.lucass.misc;

/**
 * Created by LugovoyAV on 06.08.2015.
 */
public interface MyList<T> {
    void add(T value);
    T get(int position);
    void insert(T value, int position);
    void set(T value, int position);
    void remove(int position);
    int size();
}
