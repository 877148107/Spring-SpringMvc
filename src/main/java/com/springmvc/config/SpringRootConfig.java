package com.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @ClassName: SpringRootConfig
 * =================================================
 * @Description: Spring容器配置类，父容器,
 *               容器组件扫描排除controller，controller由web配置去扫描
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2019/12/7 23:05
 * @Version: V1.0
 */
@ComponentScan(value = "com.springmvc.annotation",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
public class SpringRootConfig {
}
