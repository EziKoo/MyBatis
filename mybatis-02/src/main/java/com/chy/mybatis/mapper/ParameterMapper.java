package com.chy.mybatis.mapper;

import com.chy.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {
    /**
     * 查询所有的员工信息
     */
    List<User> getAllUser();


    /**
     * 根据用户名查询用户信息
     */
    User getUserByUserName(String username);


    /**
     * 验证登录
     */
    User checkLogin(String username, String password);


    /**
     * 验证登录（参数为map）
     */
    User checkLoginByMap(Map<String, Object> map);


    /**
     * 添加用户信息
     */
    int insertUser(User user);
}
