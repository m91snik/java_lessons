package com.gorbachevskaya.homework3;

/**
 * Created by Ангелина on 30.07.2015.
 */
public interface Collecctions<T> {
    void create(int size);
    T read(int index);
    void update(int index, T value);
    void delete(T value);
}
