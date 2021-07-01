package com.example.hystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "producer",fallback = ConsumerHystrix.class)
public interface ConsumerInterface {
    @GetMapping("producer/info")
    String getInfo();
}
