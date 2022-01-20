package com.lgd.service;

import com.lgd.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author LGD
 * @version 1.0
 * @date 2022/1/19 13:04
 */
@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {
    @RequestMapping("/dept/add/{dname}")
    boolean addDept(@PathVariable("dname")String dname);

    @RequestMapping("/dept/get/{id}")
    Dept queryById(@PathVariable("id") Long id);

    @RequestMapping("/dept/list")
    List<Dept> queryAll();
}
