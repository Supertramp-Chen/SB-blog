package com.example.sblog.configuration;

import com.example.sblog.service.OrderService;
import com.example.sblog.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class JConfiguration {
    @Configuration
    //@Configuration 代表是一个 Java 配置文件 ， Spring会根据它来生成 IoC 容器去装配 Bean
    public class JavaConfiguration {
        //想要一个US
        //告诉S 我要的bean 依赖于谁 如何创建
        @Bean
        //@Bean 允许我们在 Spring Configuration 类中创建一个 Bean
        public UserService getUService() {
            return new UserService();
        }
        @Bean
        public OrderService getOService() {
            return new OrderService(getUService());
        }
    }
}
