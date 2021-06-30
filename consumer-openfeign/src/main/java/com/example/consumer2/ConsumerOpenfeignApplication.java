package com.example.consumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerOpenfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenfeignApplication.class, args);
    }

}
