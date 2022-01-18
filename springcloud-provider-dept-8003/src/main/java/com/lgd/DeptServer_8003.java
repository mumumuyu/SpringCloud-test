package com.lgd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptServer_8003 {
    public static void main(String[] args) {
        SpringApplication.run(DeptServer_8003.class,args);
    }
}
