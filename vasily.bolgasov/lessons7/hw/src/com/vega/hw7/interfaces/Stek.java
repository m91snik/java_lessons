package com.vega.hw7.interfaces;

/**
 * Created by Вася-Вега on 05.08.2015.
 */
public interface Stek<T> {

    void addStack(T element);
    int checkLength();
    T showStack();
    T getStack();
    int searchElement(T element);

}
