package com.zjl.springcloud.controller;

import com.zjl.springcloud.pojo.Dept;
import com.zjl.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供Restful服务
@RestController
public class DeptController {
    @Autowired
    private DeptService service;
    @Autowired
    private DiscoveryClient client;

    @PostMapping("dept/add")
    public Boolean add(Dept dept) {
        return service.add(dept);
    }

    @GetMapping("dept/info/{id}")
    public Dept info(@PathVariable("id") Long id) {
        return service.info(id);
    }

    @GetMapping("dept/list")
    public List<Dept> list() {
        return service.list();
    }

    @GetMapping("dept/getDiscovery")
    public Object getDiscovery() {
        List<String> services = client.getServices();
        for (String s : services) {
            System.out.println("discoveryService=>" + s);
        }
        List<ServiceInstance> list = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : list) {
            System.out.println(instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId());
        }
        return this.client;
    }
}
