package com.lgd.service;

import com.lgd.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LGD
 * @version 1.0
 * @date 2022/1/19 14:56
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public boolean addDept(String dname) {
                return false;
            }

            @Override
            public Dept queryById(Long id) {
                return new Dept(id,
                        "id=>" + id + "没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭",
                        "没有数据~");
            }
            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
