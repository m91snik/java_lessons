package com.makedonsky94.socket;

import com.makedonsky94.socket.interfaces.ServerComponent;
import com.makedonsky94.socket.main.MainReader;
import com.makedonsky94.socket.main.MainWriter;

/**
 * Created by Sasha on 02.09.2015.
 */
public class ServerWorker {
    ServerComponent mainReader;
    ServerComponent mainWriter;

    public ServerWorker(ServerComponent mainReader, ServerComponent mainWriter) {
        this.mainReader = mainReader;
        this.mainWriter = mainWriter;
    }

    public void startServerWorker() {
        new Thread(this.mainReader::start).start();
        new Thread(this.mainWriter::start).start();
    }
}
