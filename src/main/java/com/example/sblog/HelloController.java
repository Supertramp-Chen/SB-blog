package com.example.sblog;

import com.example.sblog.service.OrderService;
import com.example.sblog.service.User;
import com.example.sblog.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

//为简单的 Web 应用程序创建一个 Web 控制器

//@RestController 意味着 Spring MVC 可以使用它来处理 Web 请求
@RestController
public class HelloController {
    /*注入OS
    告诉S 如何创建OS
    对bean进行配置 使其自动装配
    配置方式
        xml(历史，老)
            一个 xml 配置文件 src/main/resources/applicationContext.xml
            一个读取该 xml 文件的 Config 类文件
        注解@(推荐)
    */
    /*private OrderService orderService;

    @Inject
    public HelloController(OrderService orderService) {
        this.orderService = orderService;
    }

    *//*
     * @GetMapping映射/到index()方法
     * 当从浏览器调用或在命令行上使用 curl 时，该方法返回纯文本。
     * 这是因为@RestController结合了@Controller和@ResponseBody，这两个注释会导致 Web 请求返回数据而不是视图。
     * *//*
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }*/

    //    把服务注入进来，通过页面去访问
//    直接在controller里依赖这个服务
    private UserService userService;

    @Inject
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public User index() {
//直接用它访问数据库
        return this.userService.getUserId(1);
    }
}