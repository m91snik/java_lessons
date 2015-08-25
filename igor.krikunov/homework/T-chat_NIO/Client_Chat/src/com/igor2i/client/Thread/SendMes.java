package com.igor2i.client.Thread;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;

/**
 * Created by igor2i on 16.08.2015.
 */
public class SendMes implements Runnable {

    private ServerSocketChannel clientSSC;
    private String nick;
    private String IP_SERVER;
    private int PORT_SERVER;

    public SendMes(ServerSocketChannel clientSSC,String nick,String IP_SERVER,int PORT_SERVER){
        this.clientSSC = clientSSC;
        this.nick = nick;
        this.IP_SERVER = IP_SERVER;
        this.PORT_SERVER = PORT_SERVER;
    }

    private static boolean stoped = false;

    public static void setStop() {
        stoped = true;
    }


    @Override
    public void run() {

        Selector selector = null;
        try {
            selector = SelectorProvider.provider().openSelector();


            SocketChannel clientSC = SocketChannel.open();
            clientSC.configureBlocking(false);
            clientSC.connect(new InetSocketAddress(IP_SERVER, PORT_SERVER));

            clientSC.register(selector, SelectionKey.OP_CONNECT);

            while (!stoped) {

                while (selector.select(500) > 0 & !stoped) {

                    selector.select();
                    Iterator<SelectionKey> it = selector.selectedKeys().iterator();

                    while (it.hasNext()) {

                        SelectionKey key = it.next();
                        it.remove();
                        if (key.isValid()) {

                            if (key.isConnectable()) {
                                //System.out.println("Server OK");

                                clientSC.finishConnect();

                                SocketChannel channelHead = (SocketChannel) key.channel();

                                StringBuffer stringBuffer = new StringBuffer();

                                stringBuffer.append(clientSSC.socket());
                                stringBuffer.append("****");
                                stringBuffer.append(nick);

                                channelHead.write(ByteBuffer.wrap(stringBuffer.toString().getBytes()));

                                //Отправляем входящий порт и свой ник
                                //System.out.println(stringBuffer.toString());

                                clientSC.register(selector, SelectionKey.OP_WRITE);


                            } else if (key.isWritable()) {
                                String mesg = new BufferedReader(new InputStreamReader(System.in)).readLine();
                                if(mesg.equals("")){
                                    continue;
                                }

                                SocketChannel channel = (SocketChannel) key.channel();
                                //TODO: Add stream for Scanner
                                //System.out.println("Server WRITE");

                                if (channel.isConnectionPending()) {
                                    channel.finishConnect();
                                }

                                ByteBuffer buffer = null;

                                if ("exit".equals(mesg)) {

                                    buffer = ByteBuffer.wrap("Bye".getBytes());
                                    channel.write(buffer);
                                    buffer.clear();

                                    key.cancel();
                                    key.channel().close();
                                    clientSC.close();

                                    clientSSC.close();
                                    ListenerMes.setCloseServer();
                                    ListenerMes.setStop();
                                    setStop();

                                } else if (!"".equals(mesg)) {
                                    buffer = ByteBuffer.wrap( mesg.getBytes());
                                    channel.write(buffer);
                                    buffer.clear();
                                }


                            } else if (key.isAcceptable()) {
                                // Принимаем соединение
                                //System.out.println("Принимаем соединение");

                            } else if (key.isReadable()) {
                                //Читаем данные
                                //System.out.println("Читаем данные");

                            }

                        }
                    }
                }
                clientSC.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
