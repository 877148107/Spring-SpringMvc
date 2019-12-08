package com.springmvc.annotation.service.impl;

import com.springmvc.annotation.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: HelloServiceImpl
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2019/12/7 23:06
 * @Version: V1.0
 */
@Service
public class HelloServiceImpl implements HelloService {
    public String sayHello() {
        return "SpringMvc-annotation";
    }
}
