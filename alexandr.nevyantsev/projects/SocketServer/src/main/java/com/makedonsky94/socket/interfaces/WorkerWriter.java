package com.makedonsky94.socket.interfaces;


import com.makedonsky94.socket.Client;
import com.makedonsky94.socket.Message;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sasha on 02.09.2015.
 */
public interface WorkerWriter {
    Message getMessage() throws InterruptedException;
    ConcurrentHashMap<String, Client> getClients();
}
