package com.lexsus.chat.producer;

import com.lexsus.chat.spring.java.MessageType;

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

//    public ClientProducer(MessageGenerator<E> generator) {
//        this.generator = generator;
//    }

    protected String getlogin(Scanner scanner){
        if (scanner.hasNext())
            return scanner.next();
        else return null;
    }

    @Override
    public void produce() throws ProducerException {
        //logger.info("Client write start thread!");
        Scanner scanner = new Scanner(System.in);
        String text = "";
        for (; scanner.hasNext(); text = scanner.next()) {
            if ("exit".equals(text)) {
                return;
            }
            if ("login".equals(text)) {
                String login = getlogin(scanner);
                MessageType.LOGIN.sendMessage(ip_address, client_port, login, new Integer(server_port).toString());
                continue;
            }
            if ("log_chat_on".equals(text)) {
                MessageType.LOG_FILE_ON.sendMessage(ip_address, client_port, null, null);
                continue;
            }
            if ("log_chat_off".equals(text)) {
                MessageType.LOG_FILE_OFF.sendMessage(ip_address, client_port, null, null);
                continue;
            }
            if (!text.isEmpty())
                MessageType.MESSAGE.sendMessage(ip_address, client_port, text, null);
        }
    }
}
