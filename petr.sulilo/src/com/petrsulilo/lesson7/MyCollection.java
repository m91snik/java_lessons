package com.petrsulilo.lesson7;

/**
 * Created by Petr on 04.08.2015.
 */
public class MyCollection<T> {

    private T[] array;

    public MyCollection(T[] array)
    {
        this.array = array;
    }

    public int compare(MyCollection<T> myCollection)
    {
        int min = Math.min(this.array.length, myCollection.array.length);
        for (int i = 0; i < min; i++)
        {
            int compareResult = compare(this.array[i]), myCollection.array[i]);

        }
    }

    public  int compare(T o1,
                        T o2)
    {
        //TODO: impl
    }
}
