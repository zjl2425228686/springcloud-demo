package com.zjl.springcloud.service;

import com.zjl.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Boolean add(Dept dept) {
                return null;
            }

            @Override
            public Dept info(Long id) {
                return new Dept().setId(id).setName("服务降级").setSource("没有数据");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
