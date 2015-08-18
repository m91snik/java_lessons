package com.igor2i.server.thread;

import java.io.*;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

/**
 * Created by igor2i on 16.08.2015.
 */
public class PostMes implements Runnable {

    private BlockingQueue<String> drop;
    private LinkedList<Socket> clientSocket;
    private LinkedHashMap nickUserSocket;

    public PostMes(BlockingQueue<String> b, LinkedList<Socket> clientSocket, LinkedHashMap nickUserSocket) {
        this.drop = b;
        this.clientSocket = clientSocket;
        this.nickUserSocket = nickUserSocket;
    }

    @Override
    public void run() {

        System.out.println("Start server PostMes");
        String line = null;
        try {
            while (true) {
                try {
                    line = drop.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // пример строки:  "igor:  /pm petr привет как дела?"  [0] - от кого; [2] - "/pm";  [3] - nick; [4-n] - сообщение
                if ((line != null && line.split(" ").length >= 3 ? line.split(" ") : new String[0])[2].equals("/pm")) {

                    String nickSource = line.split(" ")[0].replace(":","");
                    Socket sS = (Socket)nickUserSocket.get(nickSource);
                    String nickDestin = line.split(" ")[3];


                    if(nickUserSocket.containsKey(nickDestin)){
                        Socket sD = (Socket)nickUserSocket.get(nickDestin);

                        BufferedWriter bOut = new BufferedWriter(new OutputStreamWriter(sS.getOutputStream(), "UTF-8"));
                        bOut.write(line.replace("/pm","пользователю") + "\r\n");
                        bOut.flush();

                        BufferedWriter bOut2 = new BufferedWriter(new OutputStreamWriter(sD.getOutputStream(), "UTF-8"));
                        bOut2.write(line.replace("/pm","PersonalMessage").replace(nickDestin,"") + "\r\n");
                        bOut2.flush();

                    }else {

                        BufferedWriter bOut = new BufferedWriter(new OutputStreamWriter(sS.getOutputStream(), "UTF-8"));

                        bOut.write("Пользователя с ником "+ nickDestin + " не найдено \r\n");
                        bOut.flush();
                    }
                    continue;
                }

                // отображение текущих пользователей чата
                if ((line != null && line.split(" ").length >= 2 ? line.split(" ") : new String[0])[2].equals("/who")) {

                    String nickSource = line.split(" ")[0].replace(":","");
                    Socket sS = (Socket)nickUserSocket.get(nickSource);

                    BufferedWriter bOut = new BufferedWriter(new OutputStreamWriter(sS.getOutputStream(), "UTF-8"));
                    bOut.write("Пользователи в чате:" + "\r\n");
                    Iterator itr = nickUserSocket.keySet().iterator();
                    while (itr.hasNext()){
                        bOut.write(itr.next().toString() + "\r\n");
                    }
                    bOut.flush();
                    continue;
                }

                // broadcast рассылка
                for (Socket s : clientSocket) {

                    BufferedWriter bOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));

                    bOut.write(line + "\r\n");
                    bOut.flush();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}