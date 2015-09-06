package com.vega.client.connection;

import java.net.InetAddress;

/**
 * Created by Вася-Вега on 06.09.2015.
 */
public class ConnectionData implements Connect {

    private Integer port;
    private String adressServer;
    private InetAddress ourAdress;
    private String ourName;
    private Integer ourPort;

    @Override
    public void setPort(Integer port) { this.port = port; }

    @Override
    public Integer getPort() { return port; }

    @Override
    public void setAdressServer(String adress) { this.adressServer = adress; }

    @Override
    public String getAdressServer() { return adressServer; }

    @Override
    public void setOurAdress(InetAddress adress) { this.ourAdress = adress; }

    @Override
    public InetAddress getOurAdress() { return ourAdress; }

    @Override
    public void setOurName(String name) { this.ourName = name; }

    @Override
    public String getOurName() { return ourName; }

    @Override
    public void setOurPort(Integer port) { this.ourPort = port; }

    @Override
    public Integer getOurPort() { return ourPort; }
}
