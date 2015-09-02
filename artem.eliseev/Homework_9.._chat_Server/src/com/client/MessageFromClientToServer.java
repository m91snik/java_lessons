package com.client;

import java.io.Serializable;

/**
 * Created by Anry on 28.08.2015.
 */
//TODO: make fields private and final
public class MessageFromClientToServer implements Serializable {
    public static final long serialVersionUID = 1L;
    public int inputClientPort;
    public String userInput;

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
