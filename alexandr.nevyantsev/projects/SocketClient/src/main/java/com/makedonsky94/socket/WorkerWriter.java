package com.makedonsky94.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Sasha on 18.08.2015.
 */
public class WorkerWriter implements Runnable {
    private String color;
    private String nick = null;
    public static final String ANSI_RESET = "\u001B[0m";

    public WorkerWriter() {
        this.color = "\u001B[3" + (Math.abs(new Random().nextInt()) % 7 + 1) + "m";
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", Main.DEFAULT_PORT)))
        {
            socketChannel.configureBlocking(false);
            //TODO: it's better to create dao layer and create FileDao implementation and just call it here!
            //TODO get relative path to resources folder
            String resourcesFolder = "./src/main/resources/";
            Path nickFilePath = Paths.get(resourcesFolder + "nick");
            if(Files.exists(nickFilePath)) {
                nick = new String(Files.readAllBytes(nickFilePath));
            }
            if(nick == null) {
                System.out.println("Input your nick name");
                nick = scanner.next();
                Files.write(nickFilePath, nick.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            }
            ByteBuffer byteBuffer = ByteBuffer.allocate(256);
            String newNick = "-nick " + nick;
            //TODO send to server serializated object with config
            byteBuffer.put(newNick.getBytes());
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()) {
                socketChannel.write(byteBuffer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        while ( true ) {
            try(SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", Main.DEFAULT_PORT)))
            {
                String msg = scanner.nextLine();
                StringBuilder stringBuilder = new StringBuilder();
                //TODO set nick in server
                stringBuilder.append(this.color);
                stringBuilder.append(nick + ANSI_RESET + ": ");
                stringBuilder.append(msg);
                ByteBuffer byteBuffer = ByteBuffer.allocate(256);
                byteBuffer.put(stringBuilder.toString().getBytes());
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()) {
                    socketChannel.write(byteBuffer);
                }
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }
}
