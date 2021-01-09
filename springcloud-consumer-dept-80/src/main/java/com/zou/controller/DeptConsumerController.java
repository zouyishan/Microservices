package com.zou.controller;

import com.zou.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    /**
     * 是遵循RestFul风格的！
     * 理解：消费者，不应该又service层
     * RestTemplate ....  模板里面有很多方法供我们调用
     * (url, 实体Map ,Class<T> responseType)
     */
    // 提供多种便捷访问远程http服务的方法， 简单的restful服务模板
    @Autowired
    private RestTemplate restTemplate;

    // 通过Ribbon。我们这里实现的应该事变量！！！
    //private static final String REST_URL_PREFIX = "http://localhost:8001";

    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";
    // 需要从 http://localhost:8001/dept/list去拿service层的东西
    // 这不同于RPC框架
    @RequestMapping("/comsumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/comsumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }


}
