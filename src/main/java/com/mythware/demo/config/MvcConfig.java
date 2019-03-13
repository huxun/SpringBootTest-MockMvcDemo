package com.mythware.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.mythware.demo.interceptor.MyInterceptor;

@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {

	@Autowired
    private MyInterceptor myInterceptor;
 
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                //addPathPatterns 用于添加拦截规则
                .addPathPatterns("/home")
                //excludePathPatterns 用于排除拦截
                //注意content-path：ding是不用填写的
                //项目启动测试接口
                //.excludePathPatterns("/")
                //钉钉回调事件
                .excludePathPatterns("/callback/**");
        super.addInterceptors(registry);
    }

}
