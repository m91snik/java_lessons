package com.gorbachevskaya.homework3;

import java.util.Arrays;

/**
 * Created by Ангелина on 30.07.2015.
 */
public class Array<T> implements Collecctions {
    int length;
    T []data;

    Array(){}

    Array(T[] data){
        length = data.length;
        this.data = data;
    }

    @Override
    public void create(int size) {
        length = size;
        data = (T[])new Object[length];
    }

    @Override
    public Object read(int index) {
        return data[index];
    }

    @Override
    public void update(int index, Object value) {
        System.out.println("In array update");
        data[index] = (T)value;
    }

    @Override
    public void delete(Object value) {
        int i = 0;
        for (; (i < length) && (data[i] != value); i++) {};

        if (i != length) {
            length--;
            for (int j = i; j < length; j++)
                data[j] = data[j+1];
        }
        //else throw exeption: value isn't exist in array};
    }

    void print() {
        System.out.println("Array:");
        for (int i = 0; i < length; i++) {
            System.out.print(data[i]+"  ");
        }
        System.out.println();
    }

    void fill (T value) {
        for (int i = 0; i < length; i++) {
            data[i] = value;
        }
    }
}
