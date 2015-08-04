package com.kamyshovcorp;

/**
 * Created by kamyshov.sergey on 28.07.15.
 */
public interface List {

    Object read(int index);
    boolean write(Object object);
    boolean update(Object updatedObject, Object newObject);
    boolean delete(Object object);

}
