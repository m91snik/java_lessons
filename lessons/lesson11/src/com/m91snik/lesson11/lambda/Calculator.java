package com.m91snik.lesson11.lambda;

/**
 * Created by Valentin on 20.08.2015.
 */
public interface Calculator<T extends Number> {

    T calc(T i, T j);
}
