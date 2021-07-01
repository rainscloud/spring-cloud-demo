package com.example.hystrix;

import org.springframework.stereotype.Component;

@Component
public class ConsumerHystrix implements ConsumerInterface{
    @Override
    public String getInfo() {
        return "hystrix-error";
    }
}
