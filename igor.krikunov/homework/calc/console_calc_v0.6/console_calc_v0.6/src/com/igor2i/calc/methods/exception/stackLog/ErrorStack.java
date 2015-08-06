package com.igor2i.calc.methods.exception.stackLog;

import java.util.Arrays;

/**
 * Created by igor2i on 06.08.15.
 */
public class ErrorStack<T extends String> {

    private T[] arr;

    public ErrorStack(T[] arr){
        this.arr = arr;
    }

    public void push(T strErr){
        arr =  Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1] = strErr;

    }

    public T pop(){
        if(arr.length > 0) {
            T out = arr[arr.length-1];
            if(arr.length > 1) {
                arr = Arrays.copyOfRange(arr, 0, arr.length-1);
            }else{
                arr = null;
            }
            return out;
        }
        return null;
    }

    public int lenght(){
        if(arr != null) {
            return arr.length;
        }else{
            return 0;
        }
    }

    public boolean isEmpty(){
        if(arr != null){
            return true;
        }else {
            return false;
        }
    }



}
