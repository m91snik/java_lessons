package com.m91snik.lesson13.consumer;

import org.springframework.stereotype.Component;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */

public class ConsumerException extends Exception {

    public ConsumerException() {
    }

    public ConsumerException(String message) {
        super(message);
    }

    public ConsumerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsumerException(Throwable cause) {
        super(cause);
    }

    public ConsumerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
