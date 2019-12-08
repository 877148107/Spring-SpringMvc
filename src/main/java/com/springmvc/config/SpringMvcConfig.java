package com.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName: SpringMvcConfig
 * =================================================
 * @Description: SpringMvc配置类，子容器
 *               过滤只扫描注解为controller的组件，禁用默认的过滤规则
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2019/12/7 23:10
 * @Version: V1.0
 */
@ComponentScan(value = "com.springmvc.annotation",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)
},useDefaultFilters = false)
@EnableWebMvc
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

}
