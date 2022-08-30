/*
* @SpringBootApplication是一个方便的注释，它添加了以下所有内容：

@Configuration: 将类标记为应用程序上下文的 bean 定义源。

@EnableAutoConfiguration：告诉 Spring Boot 根据类路径设置、其他 bean 和各种属性设置开始添加 bean。例如，如果spring-webmvc位于类路径上，则此注释将应用程序标记为 Web 应用程序并激活关键行为，例如设置DispatcherServlet.

@ComponentScan: 告诉 Spring 在包中查找其他组件、配置和服务com/example，让它找到控制器。

该main()方法使用 Spring Boot 的SpringApplication.run()方法来启动应用程序。您是否注意到没有一行 XML？也没有web.xml文件。这个 Web 应用程序是 100% 纯 Java，您不必处理任何管道或基础设施的配置。

还有一个CommandLineRunner标记为 a 的方法@Bean，它在启动时运行。它检索由您的应用程序创建或由 Spring Boot 自动添加的所有 bean。它对它们进行分类并打印出来*/

//修改应用程序类
package com.example.sblog;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SBlogApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}