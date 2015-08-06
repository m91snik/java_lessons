package com.company;

/**
 * Created by User on 04.08.2015.
 */
public class MyCollection {

    private T[] array;

    public MyCollection(T[] array){
        this.array = array;
    }



    public int compareTo (MyCollection<T> myCollection){
        int min = Math.min(this.array.length, myCollection.array.length);
        for (int i =0; i < min; i++) {
            if (this.array[i]) {

            }
        }
    }

    public int compare (T o1, T o2){
        //TODO: impl
    }
}
