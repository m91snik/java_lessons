package com.makedonsky94.main.impl;

import com.makedonsky94.main.CustomStack;
import com.makedonsky94.main.StackSizeException;

import java.util.LinkedList;

/**
 * Created by Sasha on 05.08.2015.
 */
public class CustomStackImpl<T> implements CustomStack<T> {
    private final int DEFAULT_STACK_SIZE = 5;

    public CustomStackImpl() {
        stackArray = new Object[DEFAULT_STACK_SIZE];
        LinkedList<String> list = new LinkedList<>();
    }

    private Object[] stackArray;
    private int stackIndex;

    /**
     * This method push element to CustomStackImpl
     *
     * @param element
     */
    @Override
    public void push(T element) {
        if(stackIndex == (stackArray.length - 1)) {
            Object[] temporaryStackArray = stackArray.clone();
            stackArray = new Object[getIncreasedSize(stackArray.length)];
            for(int i=0; i < temporaryStackArray.length; i++) {
                stackArray[i] = temporaryStackArray[i];
            }
        }
        stackArray[stackIndex] = element;
        stackIndex++;
    }

    /**
     * This method get element from CustomStackImpl
     *
     * @return
     */
    @Override
    public T pop() {
        if(stackIndex == 0)
            throw new StackSizeException("CustomStackImpl is empty");
        T returnedElement = (T)stackArray[stackIndex - 1];
        stackIndex--;
        return returnedElement;
    }

    /**
     * This method return new size of CustomStackImpl
     *
     * @param currentSize current size of CustomStackImpl
     * @return increased size of CustomStackImpl
     */
    private int getIncreasedSize(int currentSize) {
        if(currentSize == Integer.MAX_VALUE)
            throw new StackSizeException("CustomStackImpl is full");
        if(currentSize > (Integer.MAX_VALUE / 2))
            return Integer.MAX_VALUE;
        return currentSize * 2;
    }
}
