package com.vega.server.connectionInput;

/**
 * Created by ����-���� on 03.09.2015.
 */
public interface ConnectionInput extends Runnable {



    @Override
    void run();
    void userExit();
    void checkUser(String[] dataUser);

}
