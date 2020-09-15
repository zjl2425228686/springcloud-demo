package com.zjl.springcloud.service.impl;

import com.zjl.springcloud.dao.DeptDAO;
import com.zjl.springcloud.pojo.Dept;
import com.zjl.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDAO dao;

    @Override
    public Boolean add(Dept dept) {
        return dao.add(dept);
    }

    @Override
    public Dept info(Long id) {
        return dao.info(id);
    }

    @Override
    public List<Dept> list() {
        return dao.list();
    }
}
