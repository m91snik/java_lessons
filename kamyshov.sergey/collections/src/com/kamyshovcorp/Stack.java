package com.kamyshovcorp;

/**
 * Created by kamyshov.sergey on 05.08.15.
 */
public class Stack<E> {

    private Object[] elementData = new Object[0];
    private int size;

    public E push(E element) {
        increaseCapacity();
        elementData[size++] = element;
        return element;
    }

    public E pop() {
        if (size == 0) {
            throw new RuntimeException("The Stack is empty");
        }
        E element = (E) elementData[--size];
        reduceCapacity();
        return element;
    }

    private void increaseCapacity() {
        Object[] oldElementData = elementData;
        elementData = new Object[size + 1];
        System.arraycopy(oldElementData, 0, elementData, 0, size);
    }

    private void reduceCapacity() {
        Object[] oldElementData = elementData;
        elementData = new Object[size];
        System.arraycopy(oldElementData, 0, elementData, 0, size);
    }

    public int getSize() {
        return size;
    }
}
