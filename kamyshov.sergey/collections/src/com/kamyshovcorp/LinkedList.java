package com.kamyshovcorp;

import java.util.Arrays;

/**
 * Created by kamyshov.sergey on 29.07.15.
 */
public class LinkedList<E> implements List<E> {

    private int size;
    private Entry<E> first, last;

    @Override
    public E read(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Index can not be negative or bigger then amount of elements in list");
        }
        Entry<E> currentEntry = first;
        int counter = 0;
        while (currentEntry != null) {
            if (index == counter) {
                return currentEntry.element;
            }
            currentEntry = currentEntry.next;
            counter++;
        }
        return null;
    }

    @Override
    public boolean write(E element) {
        Entry oldLast = last;
        last = new Entry(element, null, null);
        if (size == 0) {
            first = last;
        } else {
            oldLast.next = last;
            last.prev = oldLast;
        }
        size++;
        return true;
    }


    @Override
    public boolean update(E updatedElement, E newElement) {
        Entry<E> currentEntry = first;
        while (currentEntry != null) {
            if (currentEntry.element.equals(updatedElement)) {
                currentEntry.element = newElement;
                return true;
            }
            currentEntry = currentEntry.next;
        }
        return false;
    }

    @Override
    public boolean delete(E element) {
        Entry<E> currentEntry = first;
        while (currentEntry != null) {
            if (first.element.equals(element)) {
                first = first.next;
                first.prev = null;
                size--;
                return true;
            } else if (last.element.equals(element)) {
                last = last.prev;
                last.next = null;
                size--;
                return true;
            } else if (currentEntry.element.equals(element)) {
                Entry<E> previousEntry = currentEntry.prev;
                Entry<E> nextEntry = currentEntry.next;
                previousEntry.next = currentEntry.next;
                nextEntry.prev = currentEntry.prev;
                size--;
                return true;
            }
            currentEntry = currentEntry.next;
        }
        return false;
    }

    @Override
    public String toString() {
        Object[] elements = new Object[size];
        int counter = 0;
        Entry currentEntry = first;
        while (currentEntry != null) {
            elements[counter++] = currentEntry.element;
            currentEntry = currentEntry.next;
        }
        return Arrays.toString(elements);
    }

    @Override
    public int size() {
        return size;
    }

    private static class Entry<E> {
        E element;
        Entry<E> next, prev;

        public Entry(E element, Entry<E> prev, Entry<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
