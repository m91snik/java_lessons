package com.vega.cycle.List;

/**
 * Created by Вася-Вега on 10.08.2015.
 */
public interface DoubleLinked<T> {

    void addLast(T element);

    void addFirst(T element);

    void goToNext();

    void goToPrev();

    int checkLength();

    T showThis();

    void deleteThis();

    void editThis(T element);

    void goToFirst();

    void goToLast();

    void editNextSrc(Integer id);

}
