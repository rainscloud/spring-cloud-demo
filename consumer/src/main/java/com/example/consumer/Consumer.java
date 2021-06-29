package com.example.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class Consumer {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/info")
    public String info() {
        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8201/producer/info";
        return rest.getForObject(url, String.class);
    }

    @GetMapping("/info2")
    public String info2() {
        String url = "http://producer/producer/info";
        return restTemplate.getForObject(url, String.class);
    }
}
