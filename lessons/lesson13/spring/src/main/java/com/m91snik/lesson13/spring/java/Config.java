package com.m91snik.lesson13.spring.java;

import com.m91snik.lesson13.SharedQueue;
import com.m91snik.lesson13.consumer.BaseConsumer;
import com.m91snik.lesson13.consumer.Consumer;
import com.m91snik.lesson13.generator.MessageGenerator;
import com.m91snik.lesson13.generator.StringMessageGenerator;
import com.m91snik.lesson13.processor.MessageProcessor;
import com.m91snik.lesson13.processor.StringMessageProcessor;
import com.m91snik.lesson13.producer.BaseProducer;
import com.m91snik.lesson13.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
@Configuration
@ComponentScan("com.m91snik.lesson13")
public class Config {
    //
//    @Autowired
//    SharedQueue<String> queue;

    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SharedQueue<String> queue(){
        return new SharedQueue<>();
    }

    @Bean
    public Consumer<String> consumer() {
        return new BaseConsumer<>(queue(), processor());
    }

    @Bean
    public Producer<String> producer() {
        return new BaseProducer<>(queue(), generator());
    }

    @Bean
    public MessageGenerator<String> generator() {
        return new StringMessageGenerator();
    }

    @Bean
    public MessageProcessor<String> processor() {
        return new StringMessageProcessor();
    }

    @Bean
    public StringMessageSystem messageSystem() {
        return new StringMessageSystem(consumer(), producer());
    }
}
