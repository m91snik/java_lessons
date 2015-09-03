package com.petrsulilo.networkchat;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Petr on 18.08.2015.
 */
public class Server2Tr {
    volatile static BlockingQueue<Message> q = new LinkedBlockingQueue<Message>();
    public static class Person
    {
        volatile int    id;
        volatile String name;
        volatile String hostName;
        volatile String port;

        public Person(int id, String name, String hostName, String port) {
            this.id = id;
            this.name = name;
            this.hostName = hostName;
            this.port = port;
        }

        public Person(String name, String hostName, String port) {
            this.name = name;
            this.hostName = hostName;
            this.port = port;
            id = setNewId(name, hostName, port);
        }

        public int getId() {
            return id;
        }
        private int setNewId(String name, String hostName, String port)
        {
            return 100;
        }
    }
    public static void main(String... args) throws IOException
    {
        int portNumber = 1232;
        Integer portNumber2 = 1233;

        HashMap<Integer, Person> hashMap = new HashMap();
        Person person = new Person("Kate","127.0.0.1",portNumber2.toString());

        hashMap.put(person.getId(),person);
        person = hashMap.get(person.getId());

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            //========= test for 2 server Socket =======
            ServerSocket serverSocket2 = new ServerSocket(portNumber2);
            Reciever reciever2 = new Reciever(q, serverSocket2);
            new Thread(reciever2).start();
            //========= ======================== =======
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
class Reciever implements Runnable{
    private final BlockingQueue queue;
    ServerSocket serverSocket;
    volatile Socket clientSocket;
    Message msg;
    Reciever(BlockingQueue q,ServerSocket s)
    {   queue = q;
        serverSocket = s;}

    public void run() {
        try
        {
            while (true) {
                clientSocket = serverSocket.accept();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    //System.out.println("Server: " + inputLine);
                    msg = new Message(123,"Petr", new String[]{"Sasha","Masha"},inputLine);
                    queue.put(msg);
                }
                clientSocket.close();
            }
        }
        catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + clientSocket.getPort() + " or listening for a connection");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Sender implements Runnable
{
    private volatile BlockingQueue<Message> queue;
    ServerSocket serverSocket;
    HashMap<Integer, Server2Tr.Person> hashMap;
    Message msg = new Message(123,"Petr", new String[]{"Sasha","Masha"},"Test text");

    public Sender(BlockingQueue<Message> q, ServerSocket s,HashMap<Integer, Server2Tr.Person> hashMap) throws IOException {
        queue = q;
        serverSocket = s;
        this.hashMap = hashMap;
    }

    @Override
    public void run() {

        while (true)
        {
            try {
                    msg = queue.take();
                    System.out.println("queue.take() = " + msg.toString());
                    for (Map.Entry<Integer, Server2Tr.Person> entry : hashMap.entrySet() )
                    {
                        //Integer id = entry.getKey();
                        System.out.println("In text for-each");
                        System.out.println("entry.getValue().hostName = " + entry.getValue().hostName);
                        System.out.println("entry.getValue().port = " + entry.getValue().port);
                        SendMessage(entry.getValue(), this.msg);
                    }
                } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void SendMessage(Server2Tr.Person person,Message msg)
    {
        try {
            Socket outSocket = new Socket(person.hostName, Integer.parseInt(person.port));

            PrintWriter out =
                    new PrintWriter(outSocket.getOutputStream(), true);
            System.out.println("");
            out.print(msg.toString());
            System.out.println("  Sent Message ====> " + person.hostName + ":" + person.port + " " + person.name);

            outSocket.close();
        } catch (UnknownHostException e) {
            System.out.println("Method SendMessage: UnknownHostException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Method SendMessage: IOException");
            e.printStackTrace();
        }
    }
}

class Message
{
    volatile public int      id;
    volatile public String   from;
    volatile public String[] to;
    volatile public String   text;

    public Message(int id, String from, String[] to, String text) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to=" + Arrays.toString(to) +
                ", text='" + text + '\'' +
                '}';
    }
}

