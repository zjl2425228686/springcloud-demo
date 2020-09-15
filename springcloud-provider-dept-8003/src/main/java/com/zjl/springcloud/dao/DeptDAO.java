package com.zjl.springcloud.dao;

import com.zjl.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDAO {
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
     * @return {@link List<Dept>}
     */
    List<Dept> list();
}
