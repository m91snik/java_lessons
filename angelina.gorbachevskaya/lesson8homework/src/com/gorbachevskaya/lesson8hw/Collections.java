package com.gorbachevskaya.lesson8hw;

/**
 * Created by �������� on 07.08.2015.
 */
public interface Collections<T> {
    void create(int size);
    T read(int index);
    void update(int index, T value);
    void delete(T value);
}
