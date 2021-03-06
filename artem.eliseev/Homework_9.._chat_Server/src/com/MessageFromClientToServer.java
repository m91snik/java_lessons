package com;

import java.io.Serializable;

/**
 * Created by Anry on 28.08.2015.
 */

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
        return "inputClientPort:" + inputClientPort + ", userInput:" + userInput;
    }
}
