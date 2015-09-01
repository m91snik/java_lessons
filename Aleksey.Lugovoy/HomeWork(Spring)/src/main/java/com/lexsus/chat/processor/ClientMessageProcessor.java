package com.lexsus.chat.processor;

import com.lexsus.chat.spring.java.Message;

/**
 * Created by Lexsus on 30.08.2015.
 */
//@Component
public class ClientMessageProcessor implements MessageProcessor<Message> {
    @Override
    public void process(Message message) {
        System.out.println(message.getText());
    }
}
