package com.zjl.springcloud.service;

import com.zjl.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 添加
     *
     * @param dept 部门
     * @return {@link Boolean}
     */
    Boolean add(Dept dept);

    /**
     * 信息
     *
     * @param id id
     * @return {@link Dept}
     */
    Dept info(Long id);

    /**
     * 列表
     *
     * @return {@link List <Dept>}
     */
    List<Dept> list();
}
