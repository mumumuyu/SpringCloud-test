package com.lgd;

import com.lgd.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = MyRule.class)
public class DeptComsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptComsumer_80.class,args);
    }
}
