package com.dbtest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticResourcesConfig implements WebMvcConfigurer  {

//    @Value("${spring.mvc.static-path-pattern}")
//    private String resourceHandler; //匹配url 中的资源映射
//
//    @Value("${PDF.filePath}")
//    private String location; //上传文件保存的本地目录

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/Book/PDF/**").addResourceLocations("file:E:/PDF/");

    }
}

