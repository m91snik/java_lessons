package com.lexsus.client;

import com.lexsus.server.Message;
import com.lexsus.server.MessageSaver;
import com.lexsus.server.MessageType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by LugovoyAV on 27.08.2015.
 */
public class Server {
    int server_port;
    int client_port;

    LinkedBlockingQueue<Message> queue = new LinkedBlockingQueue<>(1024) ;
    ConcurrentHashMap clientsMap = new ConcurrentHashMap<String, ClientInfo>();
    boolean stop;
    private static final Logger logger = LogManager.getLogger(Server.class);

    public Server(int server_port,int client_port){
        this.server_port = server_port;
        this.client_port = client_port;
        stop = true;
    }

    public void start(){
        stop = false;
        Runnable serverReader = ()->{
            while (!stop) {
                try (ServerSocket serverSocket = new ServerSocket(server_port)){
                    serverSocket.setSoTimeout(20000);
                    Socket client = serverSocket.accept();

                    ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
                    Message message = (Message) objectInputStream.readObject();
                    switch (message.getType()){
                        case LOGIN:
                            InetAddress address = client.getInetAddress();
                            int port = Integer.parseInt(message.getAdditional());
                            clientsMap.put(message.getText(), new ClientInfo(address.toString().substring(1), port));
                            logger.info(String.format("Client login address:%s port:%d", address.toString().substring(1),port));
                            break;
                        case MESSAGE:
                            queue.put(message);
                            MessageSaver.writeMessage(message);
                            break;
                    }
                    client.close();
                } catch (ClassNotFoundException | InterruptedException | SocketTimeoutException e) {
                    if (e instanceof SocketTimeoutException)
                        logger.info("ServerChat close by timeout!");
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable serverWriter = ()->{
            while (!stop) {
                try {
                    Message message = queue.take();
                    Set<Map.Entry<String, ClientInfo>> set = clientsMap.entrySet();
                    for (Map.Entry<String, ClientInfo> entry : set) {
                        {
                            String login = entry.getKey();
                            ClientInfo clientInfo = entry.getValue();
                            MessageType.MESSAGE.sendMessage(clientInfo.getIp_address(), clientInfo.getPort(), message.getText(),null);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(serverReader).start();
        new Thread(serverWriter).start();
    }
    public void stop(){
        stop = true;
    }
}
