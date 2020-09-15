package com.zjl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.zjl.springcloud"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.zjl.springcloud"})
public class DeptConsumerFeign_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign_80.class, args);
    }
}
