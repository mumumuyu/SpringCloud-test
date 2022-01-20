package com.lgd.controller;

import com.lgd.service.DeptService;
import com.lgd.pojo.Dept;
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
    //得到具体的微服务相关信息
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/dept/add/{dname}")
    public boolean addDept(Dept dept, @PathVariable("dname") String dname){
        dept.setDname(dname);
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return deptService.queryById(id);
    }

    @RequestMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery=>services:" + services);
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for(ServiceInstance instance:instances) {
            System.out.println(
                    instance.getHost()+"/t"+
                    instance.getPort()+"/t"+
                    instance.getUri()+"/t"+
                    instance.getServiceId()
            );
        }
        return this.discoveryClient;
    }
}
