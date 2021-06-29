package com.example.consumer2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "producer")
public interface ConsumerInterface {
    @GetMapping("producer/info")
    String getInfo();
}
