package com.zou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 类表关系映射
 */

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long deptno; // 主键
    private String dname;
    // 此数据来源那个数据库,微服务，一个服务对应一个数据库
    private String db_source;
    public Dept(String dname) {
        this.dname = dname;
    }
    /**
     * 链式写法
     * dept.setDpetNo(11).setDname("ss").setDb_source('db1')
     */
}
