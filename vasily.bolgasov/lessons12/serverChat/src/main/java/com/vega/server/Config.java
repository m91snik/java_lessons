package com.vega.server;

import com.vega.server.connectionInput.NewConnectionInput;
import com.vega.server.connectionOutput.NewConnectionOutput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Вася-Вега on 03.09.2015.
 */
@Configuration
public class Config {

    @Bean
    public NewConnectionOutput newConnectionOutput() { return new NewConnectionOutput();}

    @Bean
    public NewConnectionInput newConnectionInput() { return new NewConnectionInput();}

    @Bean
    public Spring text() {return new Spring(newConnectionOutput(), newConnectionInput());}

}
