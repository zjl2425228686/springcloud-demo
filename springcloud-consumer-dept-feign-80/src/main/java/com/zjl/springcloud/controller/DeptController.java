package com.zjl.springcloud.controller;

import com.zjl.springcloud.pojo.Dept;
import com.zjl.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptClientService service;

    @RequestMapping("consumer/dept/add")
    public Boolean info(Dept dept) {
        return service.add(dept);
    }

    @RequestMapping("consumer/dept/info/{id}")
    public Dept info(@PathVariable("id") Long id) {
        return service.info(id);
    }

    @RequestMapping("consumer/dept/list")
    public List<Dept> list() {
        return service.list();
    }
}
