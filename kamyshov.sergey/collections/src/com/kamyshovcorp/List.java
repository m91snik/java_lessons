package com.kamyshovcorp;

/**
 * Created by kamyshov.sergey on 28.07.15.
 */
public interface List<E> {

    E read(int index);

    boolean write(E element);

    boolean update(E updatedElement, E newElement);

    boolean delete(E element);

    int size();

}
