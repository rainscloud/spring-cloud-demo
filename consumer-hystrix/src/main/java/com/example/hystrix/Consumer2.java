package com.example.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer2")
public class Consumer2 {
    @Autowired
    private ConsumerInterface consumerInterface;

    @GetMapping("/info")
    public String info() {
        return consumerInterface.getInfo();
    }

}
