package com.lgd.controller;

import com.lgd.service.DeptService;
import com.lgd.pojo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * create by: LGD
     * description: 根据id查询部门，如果出现问题就走hystrixGet方法
     * create time: 2022/1/19 14:26
     *
     * @return Dept
     * @Param: id     */
    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);

        if (dept==null){
            throw new RuntimeException("这个id=>"+id+",不存在该用户，或信息无法找到~");
        }
        return dept;
    }

    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept(id,"id:"+id+"=>不存在此id","not found");
    }
}
