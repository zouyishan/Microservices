package com.zou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ribbon和eureka整合以后，客户端可以直接调用。不用关心IP地址和端口号
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptComsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptComsumer_80.class, args);
    }
}
