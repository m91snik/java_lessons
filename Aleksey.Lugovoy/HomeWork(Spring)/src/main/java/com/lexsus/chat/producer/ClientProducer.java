package com.lexsus.chat.producer;

import com.lexsus.chat.base.LaggedUserService;
import com.lexsus.chat.spring.java.MessageType;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Lexsus on 30.08.2015.
 */
//@Component
public class ClientProducer <E>  implements Producer<E>{
    final int server_port=11007;
    final int client_port=11005;
    String ip_address="127.0.0.1";

//    @Autowired
//    MessageGenerator<E> generator;

    public ClientProducer() {
    }

    protected String getText(Scanner scanner){
        if (scanner.hasNext())
            return scanner.next();
        else return null;
    }

    @Override
    public void produce(LaggedUserService service) throws ProducerException, IOException {
        //logger.info("Client write start thread!");
        System.out.println("Enter login or register....");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        //for (; scanner.hasNext(); text = scanner.next()) {
        for(;!"exit".equals(text);text = scanner.next()){

            if ("login".equals(text)) {
                System.out.println("Enter login:");
                String login = getText(scanner);
                System.out.println("Enter password:");
                String password = getText(scanner);
                MessageType.LOGIN.sendMessage(ip_address, client_port, login, server_port, password);
                continue;
            }
            if ("register".equals(text)) {
                System.out.println("Enter login:");
                String login = getText(scanner);
                System.out.println("Enter password:");
                String password = getText(scanner);
                System.out.println("Enter surname:");
                String surname = getText(scanner);
                System.out.println("Enter surname:");
                int age = System.in.read();
                MessageType.REGISTER.sendMessage(ip_address, client_port, login, server_port, password+";"+surname+";"+age);
                continue;
            }
            if ("log_chat_on".equals(text)) {
                MessageType.LOG_FILE_ON.sendMessage(ip_address, client_port, null);
                continue;
            }
            if ("log_chat_off".equals(text)) {
                MessageType.LOG_FILE_OFF.sendMessage(ip_address, client_port, null);
                continue;
            }
            if (!text.isEmpty())
                MessageType.MESSAGE.sendMessage(ip_address, client_port, text);
        }
    }
}

