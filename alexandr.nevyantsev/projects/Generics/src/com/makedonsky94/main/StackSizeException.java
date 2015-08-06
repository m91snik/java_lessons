package com.makedonsky94.main;

/**
 * Created by Sasha on 05.08.2015.
 */
public class StackSizeException extends RuntimeException {
    public StackSizeException() {
    }

    public StackSizeException(String message) {
        super(message);
    }
}
