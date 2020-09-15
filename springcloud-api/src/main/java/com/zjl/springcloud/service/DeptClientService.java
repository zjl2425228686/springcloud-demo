package com.zjl.springcloud.service;

import com.zjl.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value ="SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @PostMapping("dept/add")
    Boolean add(Dept dept);

    @GetMapping("dept/info/{id}")
    Dept info(@PathVariable("id") Long id);

    @GetMapping("dept/list")
    List<Dept> list();
}
