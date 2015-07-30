package com.kamyshovcorp;

import java.util.Arrays;

/**
 * Created by kamyshov.sergey on 29.07.15.
 */
public class LinkedList implements List {

    private int size;
    private Entry first, last;

    @Override
    public Object read(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Index can not be negative or bigger then amount of elements in list");
        }
        Entry currentEntry = first;
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
    public boolean write(Object object) {
        Entry oldLast = last;
        last = new Entry(object, null, null);
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
    public boolean update(Object updatedObject, Object newObject) {
        Entry currentEntry = first;
        while (currentEntry != null) {
            if (currentEntry.element.equals(updatedObject)) {
                currentEntry.element = newObject;
                return true;
            }
            currentEntry = currentEntry.next;
        }
        return false;
    }

    @Override
    public boolean delete(Object object) {
        Entry currentEntry = first;
        while (currentEntry != null) {
            if (first.element.equals(object)) {
                first = first.next;
                first.prev = null;
                size--;
                return true;
            } else if (last.element.equals(object)) {
                last = last.prev;
                last.next = null;
                size--;
                return true;
            } else if (currentEntry.element.equals(object)) {
                Entry previousEntry = currentEntry.prev;
                Entry nextEntry = currentEntry.next;
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

    private static class Entry {
        Object element;
        Entry next, prev;

        public Entry(Object element, Entry prev, Entry next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
