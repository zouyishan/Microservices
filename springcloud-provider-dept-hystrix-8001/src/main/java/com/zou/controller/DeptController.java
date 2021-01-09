package com.zou.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zou.pojo.Dept;
import com.zou.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 提供restful服务
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }


    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw new RuntimeException("id =>" + id + "该用户不存在");
        }
        return dept;
    }

    public Dept hystrixGet(@PathVariable("id")Long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("id=>" + id + "没有对应的信息 null-- @Hystrix")
                .setDb_source("没有数据库");
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

}
