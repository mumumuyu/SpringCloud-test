package com.lgd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author LGD
 * @version 1.0
 * @date 2022/1/20 14:22
 */
@SpringBootApplication
//开启监控
@EnableHystrixDashboard
public class DeptHystrixDashboard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptHystrixDashboard_9001.class,args);
    }
}
