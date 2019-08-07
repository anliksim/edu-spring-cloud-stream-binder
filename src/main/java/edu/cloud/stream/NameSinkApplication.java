package edu.cloud.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableBinding(Sink.class)
@EnableAutoConfiguration
@PropertySource("classpath:application-sink.properties")
public class NameSinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(NameSinkApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void handle(Person person) {
        System.out.println("Received: " + person);
    }
}
