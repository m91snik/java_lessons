package com.example.lambda;

/**
 * Created by stanislav on 20.08.15.
 */
public interface Calculator<T extends Number> {

    T calc(T i, T j);
}
