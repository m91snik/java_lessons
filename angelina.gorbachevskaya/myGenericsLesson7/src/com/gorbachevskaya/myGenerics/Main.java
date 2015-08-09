package com.gorbachevskaya.myGenerics;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        MyDataStruct<Integer> collection;
        Integer[] integers = {1,2,3,4};
        collection = new myStack<>(integers);

        collection.push(6);
        System.out.println(collection.pop());
        collection.push(6878);
        collection.print();

        System.out.println();

        collection = new myQueue<>(integers);
        collection.print();
        collection.push(586);
        collection.push(23);
        collection.pop();

        System.out.println();
        collection.print();
    }
}
