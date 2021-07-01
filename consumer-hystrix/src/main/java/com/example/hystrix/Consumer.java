package com.example.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class Consumer {
    private int i = 0;

    @Autowired
    private ConsumerInterface consumerInterface;

    //Hystrix降级
    @HystrixCommand(fallbackMethod = "getErrorInfo")
    @GetMapping("/info")
    public String info() {
        int a = 1 / 0;
        return consumerInterface.getInfo();
    }

    //配置Hystrix熔断
    @HystrixCommand(fallbackMethod = "getErrorInfo", commandProperties = {
            // 是否启用服务熔断
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求阈值,一个统计窗口内(默认10s)请求数量达到此值才会进行熔断与否的判断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 熔断器打开后经过多长时间允许一次请求尝试执行，默认值是 5000
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
            // 错误比率,窗口时间内超过 50% 的请求失败后会打开熔断器
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")})
    @GetMapping("/info2")
    public String info2() {
        i++;
        System.out.println("第"+i+"次进入info2");
        int a = 1 / 0;
        return consumerInterface.getInfo();
    }

    public String getErrorInfo() {
        return "errorInfo";
    }
}



