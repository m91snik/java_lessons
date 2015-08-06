package com.example.wildcards;

/**
 * Created by stanislav on 04.08.15.
 */
public class MyNumberCollection<T> extends MyCollection<Number> {

    public MyNumberCollection(Number... array) {
        super(array);
    }

    @Override
    public int compare(Number o1, Number o2) {
        return 0;
    }
}
