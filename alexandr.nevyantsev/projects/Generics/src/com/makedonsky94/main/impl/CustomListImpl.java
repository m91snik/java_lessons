package com.makedonsky94.main.impl;

import com.makedonsky94.main.CustomList;
import com.makedonsky94.main.ListIndexOutOfRangeException;

/**
 * Created by Sasha on 05.08.2015.
 */
public class CustomListImpl<T> implements CustomList<T> {
    private int listIndex;
    private CustomNode<T> first, last;

    /**
     * This method add item to last element of linked list
     *
     * @param element
     */
    @Override
    public void add(T element) {
        CustomNode<T> temporaryNode = last;
        last = new CustomNode<>(element, temporaryNode, null);
        if(listIndex == 0) {
            first = last;
        } else {
            temporaryNode.next = last;
        }
        listIndex++;
    }

    /**
     * This method get element of linked list by index
     *
     * @param index
     * @return element of linked list
     */
    @Override
    public T get(int index) {
        if(index < 0 || index > listIndex) {
            throw new ListIndexOutOfRangeException("Index can not be negative or bigger than list size");
        }
        CustomNode<T> currentNode = first;
        for(int i = 0; i != index && currentNode != null; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.element;
    }

    @Override
    public String toString() {
        String outString = "";
        CustomNode<T> currentNode = first;
        for(int i = 0; i < listIndex; i++) {
            outString += currentNode.element.toString() + (i == (listIndex - 1) ? "" : ", ");
            currentNode = currentNode.next;
        }
        return outString;
    }

    public int getSize() {
        return listIndex;
    }

    private static class CustomNode<T> {
        private T element;
        private CustomNode<T> prev, next;

        public CustomNode(T element, CustomNode<T> prev, CustomNode<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
