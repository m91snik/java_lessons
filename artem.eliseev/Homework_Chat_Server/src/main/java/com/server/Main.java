package com.server;

import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Anry on 03.09.2015.
 */
@Component
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server();
    }
}
