package com.igor2i.server.thread;

import com.igor2i.server.scanner.Reg;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.*;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.nio.charset.*;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by igor2i on 16.08.2015.
 */
public class Connector implements Runnable {

    private final int SERVER_PORT;

    public Connector(int SERVER_PORT) {
        this.SERVER_PORT = SERVER_PORT;
    }

    private static boolean stoped = false;

    public static void setStop() {
        stoped = true;
    }

    private int BUFFER_SIZE = 1024;

    private LinkedHashMap<String, SocketChannel> nickUserSocketIn = new LinkedHashMap<String, SocketChannel>();
    private LinkedHashMap<String, String> nickUserSocketOut = new LinkedHashMap<String, String>();


    private String bufferMessage = null;


    @Override
    public void run() {
        try {

            Selector selector = SelectorProvider.provider().openSelector();
            ServerSocketChannel serverSSC = ServerSocketChannel.open();
            serverSSC.configureBlocking(false);
            serverSSC.socket().bind(new InetSocketAddress(SERVER_PORT));

            serverSSC.register(selector, serverSSC.validOps());

            try {
                while (!stoped) {

                    selector.select();

                    Iterator<SelectionKey> it = selector.selectedKeys().iterator();

                    while (it.hasNext()) {

                        SelectionKey key = it.next();
                        it.remove();

                        if (key.isValid()) {
                            try {
                                if (key.isAcceptable()) {
                                    // Принимаем соединение
                                    //System.out.println("Принимаем соединение");

                                    SocketChannel newClientChan = ((ServerSocketChannel) key.channel()).accept();
                                    newClientChan.configureBlocking(false);
                                    newClientChan.register(key.selector(), SelectionKey.OP_READ);

                                    //accept(key);
                                } else if (key.isConnectable()) {
                                    // Устанавливаем соединение
                                    //System.out.println("Устанавливаем соединение");

                                } else if (key.isReadable()) {
                                    // Читаем данные
                                    //System.out.println("Читаем данные");
                                    //read(key);
                                    SocketChannel clientChan = (SocketChannel) key.channel();


                                    ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);

                                    try {
                                        //TODO : закончить с добавлением в буффер
                                        clientChan.read(buffer);
                                    } catch (Exception e) {
                                        //e.printStackTrace();

                                        key.cancel();
                                        key.channel().close();
                                        continue;
                                    }
                                    buffer.flip();


                                    Charset charset = Charset.forName("UTF-8");
                                    CharsetDecoder decoder = charset.newDecoder();
                                    CharBuffer charBuffer = decoder.decode(buffer);
                                    String str = charBuffer.toString();

                                    if ("Bye".equals(str)) {
                                        String nick = nickUserSocketOut.get(clientChan.getRemoteAddress().toString());
                                        nickUserSocketIn.remove(nick);
                                        System.out.println("Пользователь " + nick + " покинул чат");
                                        //TODO доработать!
                                        bufferMessage = "Пользователь " + nick + " покинул чат";

                                        key.cancel();
                                        key.channel().close();

                                    } else if (Reg.regServSocket(str)) {

                                        //System.out.println("Пришёл сервер сокет");
                                        String[] serverSocketOut = Reg.splitServSocket(str);

                                        nickUserSocketOut.put(clientChan.getRemoteAddress().toString(), serverSocketOut[1]);

                                        System.out.println("Новый пользователь в чате:  " + serverSocketOut[1]);

                                        if(bufferMessage != null){
                                            bufferMessage += "\r\n"+"Новый пользователь в чате:  " + serverSocketOut[1];
                                        }else {
                                            bufferMessage = "Новый пользователь в чате:  " + serverSocketOut[1];
                                        }

                                        SocketChannel clientSC = SocketChannel.open();
                                        clientSC.configureBlocking(false);
                                        clientSC.connect(new InetSocketAddress(serverSocketOut[2], Integer.parseInt(serverSocketOut[3])));

                                        clientSC.register(selector, SelectionKey.OP_WRITE);

                                        clientSC.finishConnect();
                                        nickUserSocketIn.put(serverSocketOut[1], clientSC);


                                    } else {
                                        //послать буфер на считывание

                                        String nick = nickUserSocketOut.get(clientChan.getRemoteAddress().toString());


                                        System.out.println(nick + "<read>: " + str);

                                        key.attach(nick + ": " + str); //+ "\r\n"
                                        key.interestOps(SelectionKey.OP_WRITE);

                                    }

                                } else if (key.isWritable()) {
                                    // Пишем данные
                                    //System.out.println("Пишем данные");

                                    String mesg = (String) key.attachment();

                                    if (mesg == null && bufferMessage == null) {
                                        key.interestOps(SelectionKey.OP_READ);
                                        break;
                                    } else if (mesg == null && bufferMessage != null) {
                                        mesg = bufferMessage;
                                        bufferMessage = null;
                                    }


                                    //String nick = Reg.getNick(mesg);
                                    // System.out.println(nick);

                                    if (Reg.regWho(mesg)) {

                                        StringBuilder whoOnline = new StringBuilder();
                                        Iterator<String> itUser = nickUserSocketIn.keySet().iterator();
                                        while (itUser.hasNext()) {
                                            String userS = itUser.next();
                                            SocketChannel socket = nickUserSocketIn.get(userS);
                                            try {
                                                socket.finishConnect();
                                                whoOnline.append(userS).append("\r\n");
                                            } catch (ClosedChannelException e) {
                                                itUser.remove();
                                            }
                                        }
                                        SocketChannel socket = nickUserSocketIn.get(Reg.getNick(mesg));
                                        socket.write(ByteBuffer.wrap(whoOnline.toString().getBytes()));


                                    } else if (Reg.regPM(mesg)) {
                                        String[] personalMes = Reg.getPM(mesg);
                                        if(!personalMes[0].equals("Error: ArrayIndexOutOfBoundsException")) {
                                            if (nickUserSocketIn.containsKey(personalMes[1])) {
                                                SocketChannel socketD = nickUserSocketIn.get(personalMes[1]);
                                                socketD.write(ByteBuffer.wrap((personalMes[0] + "<pm>: " + personalMes[2]).getBytes()));

                                                SocketChannel socketS = nickUserSocketIn.get(personalMes[0]);
                                                socketS.write(ByteBuffer.wrap(("<pm>" + personalMes[1] + ": " + personalMes[2]).getBytes()));
                                            } else {
                                                SocketChannel socketS = nickUserSocketIn.get(personalMes[0]);
                                                socketS.write(ByteBuffer.wrap(("Пользователь с ником \"" + personalMes[1] + "\", в чате не найден.").getBytes()));
                                            }
                                        }

                                    } else {
                                        if(bufferMessage != null){
                                            mesg = mesg + "\r\n" +bufferMessage;
                                            bufferMessage = null;
                                        }
                                        //broadcast
                                        Iterator<String> itUser = nickUserSocketIn.keySet().iterator();
                                        while (itUser.hasNext()) {
                                            String userS = itUser.next();
                                            SocketChannel socket = nickUserSocketIn.get(userS);
//                                      System.out.println(mesg);
                                            try {
                                                socket.finishConnect();
                                                socket.write(ByteBuffer.wrap(mesg.getBytes()));

                                            } catch (ClosedChannelException e) {
                                                itUser.remove();
                                            }
                                        }
                                    }

                                    key.interestOps(SelectionKey.OP_READ);

                                }
                            } catch (Exception e) {
                                e.printStackTrace();

                                key.cancel();
                                key.channel().close();
                                System.out.println("Error");
                            }
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (ClosedChannelException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

