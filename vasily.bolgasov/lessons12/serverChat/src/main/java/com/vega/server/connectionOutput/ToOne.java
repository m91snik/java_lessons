package com.vega.server.connectionOutput;

/**
 * Created by Вася-Вега on 10.09.2015.
 */
public interface ToOne {

    void aboutUser(String[] user, String message);
    void countUser(String[] user);
    void whisper(String[] user, String message);
    void updateUser(String[] user, String meessage);


}
