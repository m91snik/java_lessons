package com.vega.server.connectionInput;

import com.vega.server.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ListIterator;

/**
 * Created by Вася-Вега on 01.09.2015.
 */
//@Component
public class NewConnectionInput implements ConnectionInput {

    private static final Logger log = LogManager.getLogger(Main.class);
    Socket client;
    private static BufferedReader input;
    String inputMessage;
    String[] whoSend;

    public NewConnectionInput() {
    }

    public void newInput(Socket socket){
        this.client = socket;
    }

    @Override
    public void run() {

        try {
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));

            whoSend = input.readLine().split(" - ");
            checkUser(whoSend);

            /*
             * Get message user and save it in buffer
             * Open new Socket for read message and close it
             */

            inputMessage = input.readLine();

            if (inputMessage.equalsIgnoreCase("exit") || inputMessage.equalsIgnoreCase("close")){
                userExit();
                Main.blockingQueue.put("User: " + whoSend[2] + " exit");
            }else{
                Main.blockingQueue.put(whoSend[2] + ": " + inputMessage);
                System.out.println("We get: '" + inputMessage + "' from " + whoSend[2]);
            }
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void userExit() {
        ListIterator<String[]> itr = Main.outputUsers.listIterator();
        String[] user;
        int i = 0;
        while (itr.hasNext()){
            user = itr.next();
            if(user[0].equals(whoSend[0]) && user[1].equals(whoSend[1])
                    && user[2].equals(whoSend[2])) {
                System.out.println("User: " + whoSend[2] + " exit");
                log.info("Connection close user: " + whoSend[0] + ", " + whoSend[1]
                        + ", " + whoSend[2]);
                break;
            }
            i++;
        }
        Main.outputUsers.remove(i);
    }

    /*
     * Check it is new user or not
     */

    @Override
    public void checkUser(String[] dataUser){
        ListIterator<String[]> itr = Main.outputUsers.listIterator();
        String[] user;

        boolean newUser = true;
        while (itr.hasNext()) {
            user = itr.next();
            if(user[0].equals(dataUser[0]) && user[1].equals(dataUser[1])
                    && user[2].equals(dataUser[2])){
                newUser = false;
            }
        }

        if (newUser == true){
            log.info("Connection new user: " + dataUser[0] + ", " + dataUser[1]
                    + ", " + dataUser[2]);
            System.out.println("New connection");
            Main.outputUsers.add(dataUser);
        }

    }

}
