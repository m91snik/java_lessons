package com.kamyshovcorp.client;

import com.kamyshovcorp.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by kamyshov.sergey on 02.09.15.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Client client = context.getBean("client", Client.class);
        client.runClient();
    }
    
}
