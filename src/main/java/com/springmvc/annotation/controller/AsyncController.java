package com.springmvc.annotation.controller;

import com.springmvc.annotation.service.DeferredResultQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @ClassName: AsyncController
 * =================================================
 * @Description: SpringMvc异步请求
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2019/12/8 21:18
 * @Version: V1.0
 */
@Controller
public class AsyncController {


    @ResponseBody
    @RequestMapping("/createOrder")
    public DeferredResult<Object> createOrder(){
        DeferredResult<Object> deferredResult = new DeferredResult<Object>((long)5000, "create fail...");

        DeferredResultQueue.save(deferredResult);

        return deferredResult;
    }


    @ResponseBody
    @RequestMapping("/create")
    public String create(){
        //创建订单
        String order = UUID.randomUUID().toString();
        DeferredResult<Object> deferredResult = DeferredResultQueue.get();
        deferredResult.setResult(order);
        return "success===>"+order;
    }

    /**
     * 控制器返回Callable。
     *
     * Spring MVC调用request.startAsync()并将其提交Callable到TaskExecutor一个单独的线程中进行处理。
     *
     * 同时DispatcherServlet，所有Filter退出Servlet容器线程，但响应保持打开状态。
     *
     * 最终Callable产生一个结果，Spring MVC将请求分派回Servlet容器以完成处理。
     *
     * 在DispatcherServlet再次调用和处理与来自所述异步生产返回值恢复Callable。
     * @return
     */
    @ResponseBody
    @RequestMapping("/async")
    public Callable<String> async() {
        System.out.println("主线程开始。。。。。。。。。。。。。。。。。。。。。。"+System.currentTimeMillis());
        Callable<String> callable = new Callable<String>() {


            public String call() throws Exception {
                System.out.println("副线程开始。。。。。。。。。。。。。。。。。。。。。。"+System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println("副线程开始。。。。。。。。。。。。。。。。。。。。。。"+System.currentTimeMillis());
                return "hello SpringMvc Async";
            }
        };
        System.out.println("主线程开始。。。。。。。。。。。。。。。。。。。。。。"+System.currentTimeMillis());
        return callable;
    }

}
