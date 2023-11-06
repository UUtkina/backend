package ait.de.config;


import ait.de.model.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {


    @Bean
    public Message printMessage() {
        return new Message("Hello");
    }
}
