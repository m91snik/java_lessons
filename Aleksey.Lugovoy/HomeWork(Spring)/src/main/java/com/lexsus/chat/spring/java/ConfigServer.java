package com.lexsus.chat.spring.java;

import com.lexsus.chat.ServerMessageSystem;
import com.lexsus.chat.SharedMap;
import com.lexsus.chat.SharedQueue;
import com.lexsus.chat.consumer.Consumer;
import com.lexsus.chat.consumer.ServerConsumer;
import com.lexsus.chat.generator.MessageGenerator;
import com.lexsus.chat.generator.ServerMessageGenerator;
import com.lexsus.chat.processor.MessageProcessor;
import com.lexsus.chat.processor.ServerMessageProcessor;
import com.lexsus.chat.producer.Producer;
import com.lexsus.chat.producer.ServerProducer;
import com.lexsus.chat.saver.FileMessageSaver;
import com.lexsus.chat.saver.MessageSaver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Lexsus on 30.08.2015.
 */
@Configuration
@ComponentScan("com.m91snik.lesson13")
public class ConfigServer {
    //
//    @Autowired
//    SharedQueue<String> queue;

    @Bean
    public MessageSaver<Message> saver(){return  new FileMessageSaver();}
    @Bean
    public SharedQueue<Message> queue(){
        return new SharedQueue<>();
    }

    @Bean
    public SharedMap<String,ClientInfo> map(){
        return new SharedMap<>();
    }

    @Bean
    public Consumer<Message> consumer() {
        return new ServerConsumer<>(queue(), processor());
    }

    @Bean
    public Producer<Message> producer() {
        return new ServerProducer<>(queue(), generator());
    }

    @Bean
    public MessageGenerator<Message> generator() {
        return new ServerMessageGenerator(saver());
    }

    @Bean
    public MessageProcessor<Message> processor() {
        return new ServerMessageProcessor(map());
    }

    @Bean
    public ServerMessageSystem serverSystem() { return new ServerMessageSystem(consumer(), producer());
    }
}

