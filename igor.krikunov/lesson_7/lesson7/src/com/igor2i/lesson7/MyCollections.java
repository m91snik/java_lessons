package com.igor2i.lesson7;

/**
 * Created by igor2i on 04.08.15.
 */
public abstract class MyCollections<T> {

    private T[] array;

    public MyCollections(T[] array){
        this.array = array;
    }

    public void add(T element){
        int idx = ;
        array[idx++] = element;
    }

    public int compareTo(MyCollections<? extends T> myCollections ){
        int min = Math.min(this.array.length, myCollections.array.length);
        for(int i =0;i<min;i++){
            int compareResult = compare(this.array[i],myCollections.array[i]);

            if(compareResult != 0){
                return compareResult;
            }
        }
        return Integer.compare(this.array.length, myCollections.array.length);
    }

    public abstract int compare(T o1, T o2);
        //TODO: impl

}
