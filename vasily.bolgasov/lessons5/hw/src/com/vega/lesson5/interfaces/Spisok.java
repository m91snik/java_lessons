package com.vega.lesson5.interfaces;

/**
 * Created by Вася-Вега on 02.08.2015.
 */
public interface Spisok<E> {

    void addItem(E Item);
    void addItemTo(int Num, E Item);
    void deleteItem(int Num);
    void updateItem(int Num, E Item);
    E showItem(int Num);
    void showAll();
    int lengthList();

}
