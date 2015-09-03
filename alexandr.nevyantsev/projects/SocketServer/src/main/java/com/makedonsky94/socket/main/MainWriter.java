package com.makedonsky94.socket.main;

import com.makedonsky94.socket.Message;
import com.makedonsky94.socket.ProjectLogger;
import com.makedonsky94.socket.interfaces.ServerComponent;
import com.makedonsky94.socket.interfaces.WorkerReader;
import com.makedonsky94.socket.interfaces.WorkerWriter;

import java.io.IOException;
import java.net.ConnectException;

/**
 * Created by Sasha on 02.09.2015.
 */
public class MainWriter implements ServerComponent {
    WorkerWriter workerWriter;

    public MainWriter(WorkerWriter workerWriter) {
        this.workerWriter = workerWriter;
    }

    @Override
    public void start() {
        workerWriter.runWriter();
    }
}
