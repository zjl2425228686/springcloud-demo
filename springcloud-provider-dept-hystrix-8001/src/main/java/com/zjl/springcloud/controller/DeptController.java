package com.zjl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zjl.springcloud.pojo.Dept;
import com.zjl.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//提供Restful服务
@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @GetMapping("dept/info/{id}")
    @HystrixCommand(fallbackMethod = "hystrixInfo")
    public Dept info(@PathVariable("id") Long id) {
        Dept dept = service.info(id);
        if (dept == null) {
            throw new RuntimeException("id:" + id + "不存在");
        }
        return dept;
    }

    public Dept hystrixInfo(Long id) {
        return new Dept().setId(id).setName("没有数据 ").setSource("no this database in MYSQL");
    }
}
