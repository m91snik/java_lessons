package com.vega.server;

import com.vega.server.connectionInput.NewConnectionInput;
import com.vega.server.connectionOutput.NewConnectionOutput;
import org.springframework.stereotype.Service;

import java.net.Socket;

/**
 * Created by Вася-Вега on 03.09.2015.
 */
@Service
public class Spring {

    NewConnectionOutput newConnectionOutput;
    NewConnectionInput newConnectionInput;

    public Spring(NewConnectionOutput newConnectionOutput, NewConnectionInput newConnectionInput) {
        this.newConnectionOutput = newConnectionOutput;
        this.newConnectionInput = newConnectionInput;
    }

    public void newInput(Socket client){
        newConnectionInput.newInput(client);
    }
}
