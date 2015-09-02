package com.kamyshovcorp;

import com.kamyshovcorp.client.Client;
import com.kamyshovcorp.server.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kamyshov.sergey on 02.09.15.
 */
@Configuration
@ComponentScan("com.kamyshovcorp")
public class Config {

    @Bean
    public Server server() {
        return new Server();
    }

    @Bean
    public Client client() {
        return new Client();
    }

}
