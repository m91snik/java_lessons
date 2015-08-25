package com.jay.generic;

/**
 * Created by User on 04.08.2015.
 */
public abstract class MyCollection<T> {

    private T[] array;

    public MyCollection(T[] array){
        this.array = array;
    }

    public int compareTo(MyCollection<T> myCollection) {
        int min = Math.min(this.array.length, myCollection.array.length);
        for (int i=0; i<min; i++){

            int compareResult = compare(this.array[i], myCollection.array[i]);
            if (compareResult !=0){

                return compareResult;
            }
        }
        return (Integer.compare(this.array.length, myCollection.array.length));
    }

    public int compare(T o1, T o2){
        //TODO: impl

        return 0;
    }

}
