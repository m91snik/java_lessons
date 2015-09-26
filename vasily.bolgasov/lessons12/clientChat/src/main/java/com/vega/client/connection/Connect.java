package com.vega.client.connection;

import java.net.InetAddress;

/**
 * Created by Вася-Вега on 06.09.2015.
 */
public interface Connect {

    void setPort(Integer port);
    Integer getPort();
    void setAdressServer(String adress);
    String getAdressServer();
    void setOurAdress(InetAddress adress);
    InetAddress getOurAdress();
    void setOurLogin(String name);
    String getOurLogin();
    void setOurPort(Integer port);
    Integer getOurPort();
    void setOurPassword(String password);
    String getOurPassword();
    void setLogin(String login);
    String getLogin();

}
