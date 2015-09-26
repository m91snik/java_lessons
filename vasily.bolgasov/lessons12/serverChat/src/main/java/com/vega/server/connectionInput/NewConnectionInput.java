package com.vega.server.connectionInput;

import com.vega.server.ChatType;
import com.vega.server.Main;
import com.vega.server.connectionOutput.ConnectionToOne;
import com.vega.server.connectionOutput.ToOne;
import com.vega.server.service.UserService;
import com.vega.server.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
            ToOne toOne = new ConnectionToOne();

            /*
             * whoSend[0] - userAdress, whoSend[1] - userPort, whoSend[2] - userLogin,
             * whoSend[3] - register or login, whoSend[4] - password
             */

            whoSend = input.readLine().split(" - ");
            if(checkUser(whoSend)==true) {

            /*
             * Get message user and addUser it in buffer
             * Open new Socket for read message and close it
             */

                inputMessage = input.readLine();

                if (inputMessage.equalsIgnoreCase("exit") || inputMessage.equalsIgnoreCase("close")) {
                    userExit();
                    Main.blockingQueue.put("User: " + whoSend[2] + " exit");
                } else {
                    String[] checkCommand = inputMessage.split(" ");
                    if (checkCommand.length < 2){ checkCommand = new String[]{" ", " "}; }
                    switch (checkCommand[1]){
                        case ".WHISP":
                            toOne.whisper(whoSend,inputMessage);
                            break;
                        case ".UPDATE":
                            toOne.updateUser(whoSend,inputMessage);
                            break;
                        case ".ONLINE":
                            toOne.countUser(whoSend);
                            break;
                        case ".SEARCH":
                            toOne.aboutUser(whoSend,inputMessage);
                            break;
                        default:
                            Main.blockingQueue.put(whoSend[2] + ": " + inputMessage);
                            System.out.println("We get: '" + inputMessage + "' from " + whoSend[2]);
                            break;
                    }
                }
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
    public boolean checkUser(String[] dataUser){
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
            boolean addNewConnection;

            if(String.valueOf(ChatType.LOGIN).equals(dataUser[3])){
                addNewConnection = checkLoginAndPassword(dataUser[2],dataUser[4]);
            }else{
                addNewConnection = addNewUser(dataUser[2],dataUser[4]);
            }
            if (addNewConnection == true) {
                log.info("Connection new user: " + dataUser[0] + ", " + dataUser[1]
                        + ", " + dataUser[2]);
                System.out.println("New connection");
                Main.outputUsers.add(dataUser);
            }else {
                errorLogin(dataUser[0],new Integer(dataUser[1]));
                return false;
            }
        }
        return true;
    }

    private boolean checkLoginAndPassword(String login, String password){
        UserService userService = new UserServiceImpl();
        return !userService.findUser(login).isEmpty();
    }

    private boolean addNewUser(String login, String password){
        UserService userService = new UserServiceImpl();
        return userService.addUser(login, password, "empty", "empty");
    }

    private void errorLogin(String address, Integer port){
        Socket client = null;
        try {
            client = new Socket(address, port);
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Error connection");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
