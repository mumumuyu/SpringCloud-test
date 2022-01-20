package com.lgd.controller;

import com.lgd.pojo.Dept;
import com.lgd.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService service;

    @RequestMapping("/consumer/dept/add/{dname}")
    public Boolean add(@PathVariable("dname")String dname){
        return service.addDept(dname);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return service.queryById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll(){
        return service.queryAll();
    }
}
