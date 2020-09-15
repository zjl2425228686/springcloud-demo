package com.zjl.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Rule {
    @Bean
    public IRule myRule(){
        return new MyRandomRule();
    }
}
