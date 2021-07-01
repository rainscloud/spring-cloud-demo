package com.example.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class Consumer {
    @Autowired
    private ConsumerInterface consumerInterface;

    @HystrixCommand(fallbackMethod = "getErrorInfo")
    @GetMapping("/info")
    public String info() {
        int a = 1 / 0;
        return consumerInterface.getInfo();
    }

    public String getErrorInfo() {
        return "errorInfo";
    }
}
