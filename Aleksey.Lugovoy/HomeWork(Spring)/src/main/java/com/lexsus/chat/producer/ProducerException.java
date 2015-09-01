package com.lexsus.chat.producer;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public class ProducerException extends Exception {

    public ProducerException() {
    }

    public ProducerException(String message) {
        super(message);
    }

    public ProducerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProducerException(Throwable cause) {
        super(cause);
    }

    public ProducerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
