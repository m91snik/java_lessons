package com.server;

import com.MessageFromClientToServer;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Anry on 22.08.2015.
 */
public class Server {
    //    static int counter = 0;
    //TODO: it's better to use ConcurrentHashMap and use clientIp as key and Connection with details as value
    //TODO: it's better to send it as input argument to both ServerIn and ServerOut
    static List<Connection> connections =
            Collections.synchronizedList(new ArrayList<Connection>());
    static BlockingQueue<String> mainQueue = new LinkedBlockingQueue<String>();


    Server() {
        //TODO: create method runServer and move this logic to that method

        ServerIn serverIn = new ServerIn(mainQueue);
        new Thread(serverIn).start();

        ServerOut serverOut = new ServerOut(mainQueue);
        new Thread(serverOut).start();

    }


}
