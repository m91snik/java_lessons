package com.m91snik.lesson13.spring.xml;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("context.xml");
        StringMessageSystem stringMessageSystem =
                applicationContext.getBean("messageSystem", StringMessageSystem.class);
        stringMessageSystem.runMessagesSystem();
    }
}
