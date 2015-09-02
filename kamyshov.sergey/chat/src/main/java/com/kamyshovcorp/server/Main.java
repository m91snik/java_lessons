package com.kamyshovcorp.server;

import com.kamyshovcorp.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by kamyshov.sergey on 02.09.15.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Server server = context.getBean("server", Server.class);
        server.runServer();
    }

}
