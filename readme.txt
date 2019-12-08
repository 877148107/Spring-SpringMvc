springmvc官网地址：https://docs.spring.io/spring/docs/5.0.15.RELEASE/spring-framework-reference/web.html#spring-web
1.web容器在启动的时候会扫描每个jar包下面META-INF/services/javax.servlet.ServletContainerInitializer
2.加载指定的类SpringServletContainerInitializer
3.spring应用一启动就会加载感兴趣的WebApplicationInitializer接口下的组件：
    3.1 AbstractAnnotationConfigDispatcherServletInitializer：注解方式的DispatcherServlet
        创建根容器：获取配置类getRootConfigClasses()注册到AnnotationConfigWebApplicationContext
        创建web的IOC容器：获取配置类getServletConfigClasses注册到AnnotationConfigWebApplicationContext
    3.2 AbstractContextLoaderInitializer：创建根容器createRootApplicationContext()
    3.3 AbstractDispatcherServletInitializer:
        创建一个web的IOC容器createServletApplicationContext()
        创建一个createDispatcherServlet(servletAppContext)，并添加到servletContext


4.@EnableWebMvc开启SpringMVC定制配置功能,继承WebMvcConfigurerAdapter即可

5.SpringMvc异步请求

