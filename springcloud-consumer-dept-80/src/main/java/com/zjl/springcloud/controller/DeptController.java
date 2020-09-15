package com.zjl.springcloud.controller;

import com.zjl.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {
    //    理解:消费者，不应该有Service层
//    RestFul
//    RestTemplate  供我们直接调用就可以了 注册到spring中
//    (url,实体,Map,Class<T> responseType)
    @Autowired
    private RestTemplate restTemplate;//提供多种便携访问远程http服务的方法，简单的RestFul服务模板

//    private static final String REST_URL_PREFIX = "http://192.168.3.4:8001/";
    //Ribbon 我们这里的地址，应该是一个变量，通过服务名来访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT/";

    @RequestMapping("consumer/dept/add")
    public Boolean info(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "dept/add",dept, Boolean.class);
    }
    @RequestMapping("consumer/dept/info/{id}")
    public Dept info(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "dept/info/" + id, Dept.class);
    }
    @RequestMapping("consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "dept/list", List.class);
    }
}
