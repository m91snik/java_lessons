package com.makedonsky94.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Sasha on 18.08.2015.
 */
public class Client {

    public Client(SocketAddress address) {
        this.address = (InetSocketAddress)address;
        this.nick = "unknown";
    }

    private final InetSocketAddress address;
    private String nick;

    public void write(Message message) throws IOException {
        //TODO remove test port 4545
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(address.getHostName(), 4545));
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        String messageString = message.getMessageString();
        byteBuffer.put(messageString.getBytes());
        byteBuffer.flip();
        while(byteBuffer.hasRemaining()) {
            socketChannel.write(byteBuffer);
        }
        socketChannel.close();
    }

    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }

}
