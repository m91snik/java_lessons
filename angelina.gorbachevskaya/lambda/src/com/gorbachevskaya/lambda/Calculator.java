package com.gorbachevskaya.lambda;

/**
 * Created by Ангелина on 20.08.2015.
 */
public interface Calculator<T extends Number> {

    T calc(T i, T j);
}
