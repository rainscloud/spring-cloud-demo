package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rainscloud
 */
@RestController
@RefreshScope
@RequestMapping("/config-client")
public class ConfigClientController {

    @Value("${hello}")
    private String hello;

    @GetMapping("/info")
    public String info() {

        return this.hello;
    }

}
