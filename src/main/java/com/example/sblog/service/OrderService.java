package com.example.sblog.service;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
@Service
public class OrderService {
    //OS依赖于US
    private UserService userService;

    //@Inject 通过 构造函数 声明依赖关系 告诉S OS依赖于US 让S把它们装配好
    @Inject
    //没有把US new出来 但能用
    //S 把依赖关系理清楚 把bean装配好
    public OrderService(UserService userService) {
        this.userService = userService;
    }

    public void placeOrder(Integer userId, String item) {
        userService.getUserId(userId);
    }
}
