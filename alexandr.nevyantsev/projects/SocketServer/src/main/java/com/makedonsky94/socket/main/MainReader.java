package com.makedonsky94.socket.main;

import com.makedonsky94.socket.interfaces.ServerComponent;
import com.makedonsky94.socket.interfaces.WorkerReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Sasha on 02.09.2015.
 */
public class MainReader implements ServerComponent {
    private static final Logger logger = LogManager.getLogger(MainReader.class);

    public MainReader(WorkerReader workerReader) {
        this.workerReader = workerReader;
    }

    WorkerReader workerReader;

    @Override
    public void start() {
        workerReader.runReader();
    }
}
