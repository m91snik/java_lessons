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
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress("localhost", workerReader.getPort()));
            MainReader.logger.info("serverSocketChannel is opened");
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            MainReader.logger.info("serverSocketChannel is registered");
            while (true) {
                int count = selector.select();
                //TODO: it will never return 0 because it's in blocking state till somebody connects to socket
                if (count == 0) {
                    continue;
                }
                Set selectedKeys = selector.selectedKeys();
                Iterator iterator = selectedKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = (SelectionKey) iterator.next();
                    if (selectionKey.isAcceptable()) {
                        SocketChannel sock = serverSocketChannel.accept();
                        if(sock != null) {
                            sock.configureBlocking(false);
                            sock.register(selector, SelectionKey.OP_READ);
                            MainReader.logger.info(selectionKey.toString() + " has been accepted");
                        }
                    }
                    if (selectionKey.isReadable()) {
                        MainReader.logger.info("Read from " + selectionKey.channel().toString());
                        SocketChannel socketChannel =
                                (SocketChannel) selectionKey.channel();
                        try {
                            workerReader.readMessage(socketChannel);
                        } catch(IOException e) {
                            MainReader.logger.info("Disconnected from server " + selectionKey.channel().toString());
                        }
                        socketChannel.close();
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
