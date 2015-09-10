package com.vega.client.connection;

import java.net.InetAddress;

/**
 * Created by Вася-Вега on 06.09.2015.
 */
public class ConnectionData implements Connect {

    private Integer port;
    private String adressServer;
    private InetAddress ourAdress;
    private String ourLogin;
    private String ourPassword;
    private Integer ourPort;
    private String login;

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
    public void setOurLogin(String name) { this.ourLogin = name; }

    @Override
    public String getOurLogin() { return ourLogin; }

    @Override
    public void setOurPort(Integer port) { this.ourPort = port; }

    @Override
    public Integer getOurPort() { return ourPort; }

    @Override
    public String getOurPassword() { return ourPassword; }

    @Override
    public void setOurPassword(String ourPassword) { this.ourPassword = ourPassword; }

    @Override
    public void setLogin(String login) { this.login = login; }

    @Override
    public String getLogin() { return login; }
}
