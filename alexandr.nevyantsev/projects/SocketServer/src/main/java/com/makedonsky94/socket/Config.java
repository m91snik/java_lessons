package com.makedonsky94.socket;

import com.makedonsky94.socket.impl.WorkerReaderImpl;
import com.makedonsky94.socket.impl.WorkerWriterImpl;
import com.makedonsky94.socket.interfaces.ServerComponent;
import com.makedonsky94.socket.interfaces.WorkerReader;
import com.makedonsky94.socket.interfaces.WorkerWriter;
import com.makedonsky94.socket.main.MainReader;
import com.makedonsky94.socket.main.MainWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sasha on 02.09.2015.
 */
@Configuration
@ComponentScan("com.makedonsky94.socket")
public class Config {

    @Bean
    BlockingQueue<Message> blockingQueue() {
        return new ArrayBlockingQueue<Message>(500);
    }

    @Bean
    ConcurrentHashMap<String, Client> clientConcurrentHashMap() {
        return new ConcurrentHashMap<>();
    }

    @Bean
    public WorkerReader workerReader() throws IOException {
        return new WorkerReaderImpl(blockingQueue(), clientConcurrentHashMap(), Main.DEFAULT_PORT);
    }

    @Bean
    public WorkerWriter workerWriter() throws IOException {
        return new WorkerWriterImpl(blockingQueue(), clientConcurrentHashMap());
    }

    @Bean
    public ServerComponent mainReader() throws IOException {
        return new MainReader(workerReader());
    }

    @Bean
    public ServerComponent mainWriter() throws IOException {
        return new MainWriter(workerWriter());
    }

    @Bean
    public ServerWorker serverWorker() throws IOException {
        return new ServerWorker(mainReader(), mainWriter());
    }
}
