package com.vega.hw7.interfaces;

/**
 * Created by Вася-Вега on 06.08.2015.
 */
public interface OneList<T> {

    void addLast(T element);
    void addFirst(T element);
    void addTo(T element, int id);
    void toTop();
    void toNext();
    T showThisElemnt();
    void deleteThisElement();
    void editThisElement(T element);
    int checkLength();

}
