package com.petrsulilo.networkchat;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Petr on 23.08.2015.
 */
public class Client2Tr {
    volatile static BlockingQueue<Message> q = new LinkedBlockingQueue<Message>();

    public static void main(String... args) throws IOException
    {
        int portNumber = 1232;

        HashMap<Integer, Server2Tr.Person> hashMap = new HashMap();
        Server2Tr.Person person = new Server2Tr.Person("Kate","127.0.0.1","1232");
        hashMap.put(person.getId(),person);
        person = hashMap.get(person.getId());

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Reciever reciever = new Reciever(q, serverSocket);
            Sender sender = new Sender(q, serverSocket,hashMap);
            new Thread(reciever).start();
            new Thread(sender).start();
        }
        catch (IOException e)
        {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            e.printStackTrace();
        }
    }
}
//class Reciever implements Runnable{
//    private final BlockingQueue queue;
//    ServerSocket serverSocket;
//    volatile Socket clientSocket;
//    Message msg;
//    Reciever(BlockingQueue q,ServerSocket s)
//    {   queue = q;
//        serverSocket = s;}
//
//    public void run() {
//        try
//        {
//            while (true) {
//                clientSocket = serverSocket.accept();
//
//                BufferedReader in = new BufferedReader(
//                        new InputStreamReader(clientSocket.getInputStream()));
//                String inputLine;
//
//
//                while ((inputLine = in.readLine()) != null) {
//                    //System.out.println("Server: " + inputLine);
//                    msg = new Message(123,"Petr", new String[]{"Sasha","Masha"},inputLine);
//                    queue.put(msg);
//                }
//                clientSocket.close();
//            }
//        }
//        catch (IOException e) {
//            System.out.println("Exception caught when trying to listen on port "
//                    + clientSocket.getPort() + " or listening for a connection");
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//class Sender implements Runnable
//{
//    private volatile BlockingQueue<Message> queue;
//    ServerSocket serverSocket;
//    HashMap<Integer, Server2Tr.Person> hashMap;
//    Message msg = new Message(123,"Petr", new String[]{"Sasha","Masha"},"Test text");
//
//    public Sender(BlockingQueue<Message> q, ServerSocket s,HashMap<Integer, Server2Tr.Person> hashMap) throws IOException {
//        queue = q;
//        serverSocket = s;
//        this.hashMap = hashMap;
//    }
//
//    @Override
//    public void run() {
//
//        while (true)
//        {
//            try {
//                msg = queue.take();
//                System.out.println("queue.take() = " + msg.toString());
//                for (Map.Entry<Integer, Server2Tr.Person> entry : hashMap.entrySet() )
//                {
//                    Integer id = entry.getKey();
//                    Server2Tr.Person person = entry.getValue();
//
//                    // отлавливать исключение
//                    Socket outSocket = new Socket(person.hostName, Integer.parseInt(person.port));
//
//                    PrintWriter out =
//                            new PrintWriter(outSocket.getOutputStream(), true);
//                    out.print(msg);
//                    outSocket.close();
//                }
//                //PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
//                //Socket echoSocket = new Socket(hostName, portNumber);
//
//
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//}

//class Message
//{
//    public int      id;
//    public String   from;
//    public String[] to;
//    public String   text;
//
//    public Message(int id, String from, String[] to, String text) {
//        this.id = id;
//        this.from = from;
//        this.to = to;
//        this.text = text;
//    }
//
//    @Override
//    public String toString() {
//        return "Message{" +
//                "id=" + id +
//                ", from='" + from + '\'' +
//                ", to=" + Arrays.toString(to) +
//                ", text='" + text + '\'' +
//                '}';
//    }
//}
class Listener
{
    BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();


    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

    String userInput;
//    while ((userInput = stdIn.readLine()) != null)
//    {
//
//    }
}

























