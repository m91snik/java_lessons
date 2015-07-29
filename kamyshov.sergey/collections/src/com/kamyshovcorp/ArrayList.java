package com.kamyshovcorp;

import java.util.Arrays;

/**
 * Created by kamyshov.sergey on 28.07.15.
 */
public class ArrayList implements List {

    private final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public ArrayList() {
        data = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        if (capacity >= 0) {
            data = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity can not be negative");
        }
    }

    @Override
    public Object read(int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Index is negative or bigger then amount of elemenets in list");
        }
        return data[index];
    }

    @Override
    public boolean write(Object object) {
        ensureCapacity();
        data[size++] = object;
        return true;
    }

    @Override
    public boolean update(Object updatedObject, Object newObject) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(updatedObject)) {
                data[i] = newObject;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Object object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) {
                int index = i;
                int currentLength = data.length;
                Object[] tmpDataBefore = new Object[index];
                Object[] tmpDataAfter = new Object[size - index - 1];

                System.arraycopy(data, 0, tmpDataBefore, 0, index);
                System.arraycopy(data, index + 1, tmpDataAfter, 0, size - index - 1);

                data = new Object[currentLength - 1];

                System.arraycopy(tmpDataBefore, 0, data, 0, index);
                System.arraycopy(tmpDataAfter, 0, data, index, size - index - 1);

                size--;
                return true;
            }
        }
        return false;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            Object[] tmpData = new Object[size];
            System.arraycopy(data, 0, tmpData, 0, size);
            data = new Object[size * 3 / 2 + 1];
            System.arraycopy(tmpData, 0, data, 0, size);
        }
    }

    @Override
    public String toString() {
        Object[] filledElements = new Object[size];
        for (int i = 0; i < size; i++) {
            filledElements[i] = data[i];
        }
        return Arrays.toString(filledElements);
    }

}
