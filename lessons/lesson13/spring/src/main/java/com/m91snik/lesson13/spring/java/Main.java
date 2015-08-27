package com.m91snik.lesson13.spring.java;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Config.class);
        StringMessageSystem stringMessageSystem = applicationContext.getBean(StringMessageSystem.class);
        stringMessageSystem.runMessagesSystem();
    }
}
