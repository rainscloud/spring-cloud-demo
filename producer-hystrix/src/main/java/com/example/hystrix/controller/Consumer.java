package com.example.hystrix.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class Consumer {

    @GetMapping("/info")
    @HystrixCommand(fallbackMethod = "getError")
    public String info() {
        int a = 1 / 0;
        return "producer-hystrix";
    }

    public String getError() {
        return "info接口开小差了";
    }

}
