package com.lexsus.chat.spring.java;

import com.lexsus.chat.processor.ClientMessageProcessor;
import com.lexsus.chat.processor.MessageProcessor;
import com.lexsus.chat.ClientMessageSystem;
import com.lexsus.chat.consumer.ClientConsumer;
import com.lexsus.chat.consumer.Consumer;
import com.lexsus.chat.producer.ClientProducer;
import com.lexsus.chat.producer.Producer;
import org.springframework.context.annotation.Bean;

/**
 * Created by Lexsus on 30.08.2015.
 */
public class ConfigClient {

    @Bean
    public Settings settings(){
        return new BaseSettings();
    }

    @Bean
    public Consumer<Message> consumer() {
        return new ClientConsumer(processorClient());
    }

    @Bean
    public Producer<Message> producer() {
        return new ClientProducer<>(/*generator()*/);
    }

    /*@Bean
    public MessageGenerator<Message> generator() {
        return new ClientMessageGe();
    }*/

    @Bean
    public MessageProcessor<Message> processorClient() {
        return new ClientMessageProcessor();
    }

    @Bean
    public ClientMessageSystem clientSystem() { return new ClientMessageSystem(consumer(), producer());
    }
}
