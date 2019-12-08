package com.springmvc.annotation;

import com.springmvc.config.SpringMvcConfig;
import com.springmvc.config.SpringRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @ClassName: MyWebAppInitializer
 * =================================================
 * @Description: web容器在启动的时候创建对象；调用初始化方法来初始化前端控制器
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2019/12/7 22:51
 * @Version: V1.0
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 获取根容器的配置类：spring的配置文件，父容器
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringRootConfig.class};
    }


    /**
     * 获取根容器的配置类：springmvc的配置文件，子容器
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /**
     * 获取DispatcherServlet的映射资源
     * 拦截所有的请求
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
