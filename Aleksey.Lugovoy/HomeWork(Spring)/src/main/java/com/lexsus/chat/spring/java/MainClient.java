package com.lexsus.chat.spring.java;

import com.lexsus.chat.ClientMessageSystem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Lexsus on 30.08.2015.
 */
public class MainClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConfigClient.class);
        ClientMessageSystem client = applicationContext.getBean(ClientMessageSystem.class);
        client.runMessagesSystem();
    }
}
