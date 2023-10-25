package com.chy.mapper;

import com.chy.pojo.User;

import java.util.List;

public interface UserMapper {

    /*
    * Mybatis面向接口编程的两个一致
    * 1、映射文件的namespace要和mapper接口的全类名保持一致
    * 2、映射文件中SQL语句的id要和mapper接口中的方法名一致
    *
    * 表--实体类--mapper接口--映射文件
    * */


    /**
     * 询表中数据
     * @return
     */
    List<User> getUserList();

    /**
     * 添加一条数据
     * @return
     */
    int insertInfo();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();
}
