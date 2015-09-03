package com;

import java.io.Serializable;

/**
 * Created by Anry on 28.08.2015.
 */
//TO DO: make fields private and final: Done, not both.
//Can not done private or protected from serialization ant different packages in client and server.
//How to do this?
public class MessageFromClientToServer implements Serializable {
    private static final long serialVersionUID = 1L;
    public final int inputClientPort;
    public final String userInput;

    public MessageFromClientToServer(int inputClientPort, String userInput) {
        this.inputClientPort = inputClientPort;
        this.userInput = userInput;
    }

    @Override
    public String toString() {
        String outPrintString = "inputClientPort:" + inputClientPort + ", userInput:" + userInput;
        return outPrintString;
    }
}
