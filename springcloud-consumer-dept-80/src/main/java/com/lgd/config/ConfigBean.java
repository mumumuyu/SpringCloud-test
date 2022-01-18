package com.lgd.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    //IRule
    //RoundRobinRule 轮询
    //RandomRule 随机
    //AvailabilityFilteringRule 先过滤掉一些跳闸，访问故障的服务，对剩下的进行轮询
    //RetryRule 会先按照轮询获得结果，如果服务获取失败则会在指定时间内进行重试
    @Bean
    @LoadBalanced //负载均衡实现RestTemplate
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public IRule myRule(){
//        return new RandomRule();
//    }
}
