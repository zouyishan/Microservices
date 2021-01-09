package com.zou.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    // 配置负载均衡实现RestTemplate
    // IRule负载均衡
    // AvailabilityFilteringRule 会先过滤掉，跳闸访问事故的服务，在剩下的进行轮询
    // RoundRobinRule 轮询
    // RandomRule 随机
    // RetryRule 先按照轮询获取服务，如果服务获取失败，则会在指定的时间内进行重试

    @Bean
    @LoadBalanced // 这就是Ribbon的作用
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    // 这里写自己的
    @Bean
    public IRule myRule() {
        return new RandomRule(); // 可以自己diy
    }

}
