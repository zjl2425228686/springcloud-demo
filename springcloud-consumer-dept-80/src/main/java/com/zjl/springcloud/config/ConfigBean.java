package com.zjl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    //    @Configurable --spring application.xml
//    配置负载均衡实现RestTemplate
    //IRule
    //AvailabilityFilteringRule:会先过滤掉，跳闸，访问故障的服务，对剩下的进行轮询
    //RoundRobinRule:轮询
    //RandomRule:随机
    //RetryRule:会先按照轮询获取服务，如果服务获取失败，则会在指定的时间内进行重试
    @Bean
    @LoadBalanced//Ribbon
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
