//package com.example.hystrix.service;
//
//import com.example.hystrix.FallbackHystrixServer;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Component
//@FeignClient(name = "producer", fallback = FallbackHystrixServer.class)
//public interface Consumer2Interface {
//    @GetMapping("producer/info")
//    String getInfo();
//}
