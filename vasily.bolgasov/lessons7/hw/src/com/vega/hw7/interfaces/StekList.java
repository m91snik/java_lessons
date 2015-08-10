package com.vega.hw7.interfaces;

import java.util.Objects;

/**
 * Created by Вася-Вега on 05.08.2015.
 */
public class StekList<T> implements Stek<T> {

    private int length = 0;
    Object[] listStek = new Object[0];

    @Override
    public void addStack(T element) {
        int length = this.length++;
        Object[] newListStek = new Object[this.length];
        for(int i=0;i<length;i++){
            newListStek[i]=listStek[i];
        }
        newListStek[length] = element;
        listStek = newListStek;
    }

    @Override
    public int checkLength() {
        return this.length;
    }

    @Override
    public T showStack() {
        return (T)listStek[length-1];
    }

    @Override
    public T getStack() {
        T element = (T)listStek[--length];
        Object[] newListStek = new Object[length];
        for (int i = 0; i<length; i++){
            newListStek[i] = listStek[i];
        }
        listStek = newListStek;
        return element;
    }

    @Override
    public int searchElement(T element) {
        int stekNum = 0;
        for (int i = (length-1); i>0; i--){
            if (element == listStek[i]){
                break;
            }
            stekNum++;
        }
        return stekNum;
    }

}
