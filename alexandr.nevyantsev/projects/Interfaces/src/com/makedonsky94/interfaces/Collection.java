package com.makedonsky94.interfaces;

/**
 * Created by Sasha on 30.07.2015.
 */
public interface Collection<E> {
    void add(E item);
    E get(int index);
    void delete(int index);
    void delete(E item);
    int getLength();
}
