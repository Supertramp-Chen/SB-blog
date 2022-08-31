package com.example.sblog.service;

import com.example.sblog.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
@Service
public class UserService {
//    注入mapper
//    在S容器中声明了有一个bean是UM
//    告诉S 我依赖它 请把他注入进来
//    mybatis还需要一个datasource
//    让它找到datasource
    private UserMapper userMapper;

    @Inject
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserId(Integer id){
//        return new User(1,"WWW");
    return userMapper.findUserId(id);
    }
}
