package com.gorbachevskaya.myGenerics;

/**
 * Created by �������� on 09.08.2015.
 */
public interface MyDataStruct<T> {
    void push(T element);
    T pop();
    void print();
}
