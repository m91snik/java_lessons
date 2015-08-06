package com.m91snik.generics;

/**
 * Created by Valentin on 04.08.2015.
 */
public abstract class MyCollection<T> {

    private T[] array;
    private int idx = 0;

    public MyCollection(T[] array) {
        this.array = array;
    }

    public void add(T element) {
        array[idx++] = element;
    }

    public T get(int idx) {
        return array[idx];
    }

    public int compareTo(MyCollection<? super Number> myCollection) {
        myCollection.add(new Object());

        int min = Math.min(this.array.length, myCollection.array.length);
        for (int i = 0; i < min; i++) {
            int compareResult =
                    compare(this.array[i], myCollection.array[i]);
            if (compareResult != 0) {
                return compareResult;
            }
        }
        return Integer.compare(this.array.length, myCollection.array.length);
    }

    protected abstract int compare(T o1, T o2);

}
