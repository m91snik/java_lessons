package com.igor2i.client.Thread;


import java.net.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;


/**
 * Created by igor2i on 16.08.2015.
 */
public class ListenerMes implements Runnable {

    private String nick;

    private String IP_SERVER;
    private int PORT_SERVER;

    public ListenerMes(String nick, String IP_SERVER, int PORT_SERVER) {
        this.nick = nick;
        this.IP_SERVER = IP_SERVER;
        this.PORT_SERVER = PORT_SERVER;
    }

    private static boolean stoped = false;

    public static void setStop() {
        stoped = true;
    }

    private static boolean closeServer = false;
    public static void setCloseServer(){
        closeServer = true;
    }


    @Override
    public void run() {


        try {

            Selector selector = SelectorProvider.provider().openSelector();

            ServerSocketChannel clientSSC = ServerSocketChannel.open();
            clientSSC.configureBlocking(false);
            //clientSSC.socket().bind(new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(), 0));
            clientSSC.socket().bind(new InetSocketAddress("127.0.0.1", 0));

            clientSSC.register(selector, clientSSC.validOps());

            new Thread(new SendMes(clientSSC, nick, IP_SERVER, PORT_SERVER)).start();


            while (!stoped) {

                while (selector.select(500) > 0 & !stoped) {

                    selector.select();
                    Iterator<SelectionKey> it = selector.selectedKeys().iterator();

                    while (it.hasNext()) {

                        SelectionKey key = it.next();
                        it.remove();
                        if (key.isValid()) {

                            if (key.isConnectable()) {
                                // Устанавливаем соединение
                                //System.out.println("Устанавливаем соединение");


                            } else if (key.isWritable()) {
                                // Читаем данные
                                //System.out.println("Читаем данные");


                            } else if (key.isAcceptable()) {
                                // Принимаем соединение
                                //System.out.println("Принимаем соединение");

                                SocketChannel newClientChan = ((ServerSocketChannel) key.channel()).accept();
                                newClientChan.configureBlocking(false);
                                newClientChan.register(selector, SelectionKey.OP_READ);

                            } else if (key.isReadable()) {
                                //Читаем данные
                                //System.out.println("Читаем данные");

                                SocketChannel clientChan = (SocketChannel) key.channel();

                                ByteBuffer buffer = ByteBuffer.allocate(1024);

                                try {
                                    //TODO : закончить с добавлением в буффер
                                    clientChan.read(buffer);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    key.cancel();
                                    key.channel().close();
                                    continue;
                                }
                                buffer.flip();


                                Charset charset = Charset.forName("UTF-8");
                                CharsetDecoder decoder = charset.newDecoder();
                                CharBuffer charBuffer = decoder.decode(buffer);
                                String str = charBuffer.toString();
                                System.out.println(str);
                            }
                        }
                    }
                    if(closeServer){
                        clientSSC.socket().close();
                        clientSSC.close();
                    }
                }
            }
            clientSSC.socket().close();
            clientSSC.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
