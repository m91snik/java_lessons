package com.client;

import org.springframework.stereotype.Component;

/**
 * Created by Anry on 22.08.2015.
 */
@Component
public class Client {
    String hostName;
    int portNumber;
    int inputClientPort;

    public Client(String hostName, int portNumber, int inputClientPort) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        this.inputClientPort = inputClientPort;

        runClient(hostName, portNumber, inputClientPort);
    }

    public void runClient(String hostName, int portNumber, int inputClientPort) {
        ClientIn clientIn = new ClientIn(hostName, portNumber, inputClientPort);
        new Thread(clientIn).start();

        ClientOut clientOut = new ClientOut(inputClientPort);
        new Thread(clientOut).start();
    }
}
