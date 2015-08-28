package com.server;

/**
 * Created by Anry on 28.08.2015.
 */
public class MessageFromClientToServer {
    int inputClientPort;
    String userInput;

    public MessageFromClientToServer(int inputClientPort, String userInput) {
        this.inputClientPort = inputClientPort;
        this.userInput = userInput;
    }

}
