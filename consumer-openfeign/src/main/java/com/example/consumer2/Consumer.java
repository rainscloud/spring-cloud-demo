package com.example.consumer2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class Consumer {
    @Autowired
    private ConsumerInterface consumerInterface;

    @GetMapping("/info")
    public String info() {

        return consumerInterface.getInfo();
    }

}
