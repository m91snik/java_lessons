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
    void setOurName(String name);
    String getOurName();
    void setOurPort(Integer port);
    Integer getOurPort();

}
