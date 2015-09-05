package com.lexsus.chat.spring.java;


import com.lexsus.chat.ServerMessageSystem;
import com.lexsus.chat.base.LaggedUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public class MainServer {

    public static void main(String[] args) {
        int p=0;
//        ApplicationContext applicationContext =
//                new AnnotationConfigApplicationContext(Config.class);
//        StringMessageSystem stringMessageSystem = applicationContext.getBean(StringMessageSystem.class);
//        stringMessageSystem.runMessagesSystem();

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConfigServer.class);
        ServerMessageSystem server = applicationContext.getBean(ServerMessageSystem.class);
        server.runMessagesSystem();

        LaggedUserService laggedUserService = applicationContext.getBean(LaggedUserService.class);
    }
}
