package com.lgd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author LGD
 * @version 1.0
 * @date 2022/1/20 15:02
 */
@SpringBootApplication
@EnableZuulProxy
public class zuulProxy_9527 {
    public static void main(String[] args) {
        SpringApplication.run(zuulProxy_9527.class,args);
    }
}
