package com;

/**
 * Created by Anry on 20.08.2015.
 */
public interface Calculator<T extends Number> {
    T calc (int i, int j);
}
