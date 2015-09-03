package com.makedonsky94.socket.interfaces;

import com.makedonsky94.socket.Message;

import java.io.IOException;
import java.nio.channels.SocketChannel;


/**
 * Created by Sasha on 02.09.2015.
 */
public interface WorkerReader {
    void addMessage(Message msg);
    void runReader();
}
