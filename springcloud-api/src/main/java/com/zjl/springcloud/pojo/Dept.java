package com.zjl.springcloud.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 部门
 *
 * @author zjl
 * @date 2020/09/04
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 数据源
     */
    private String source;

    public Dept(String name) {
        this.name = name;
    }
}
