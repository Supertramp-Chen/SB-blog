package com.example.sblog.mapper;

import com.example.sblog.service.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE id = #{id}")
//    City findByState(@Param("state") String state);
    //找到user
    User findUserId(@Param("id") Integer id);
}