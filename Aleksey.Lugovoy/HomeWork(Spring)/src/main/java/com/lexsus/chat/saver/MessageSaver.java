package com.lexsus.chat.saver;

/**
 * Created by Lexsus on 31.08.2015.
 */
public interface MessageSaver<E> {
    void writeMessage(E message);
}
