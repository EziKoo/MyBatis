package com.chy.mybatis.test;

import com.chy.mybatis.mapper.ParameterMapper;
import com.chy.mybatis.pojo.User;
import com.chy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {

    /**
     * MyBatis获取参数值的两种方式： ${}和#{}
     * ${}本质字符串拼接
     * #{}本质占位符赋值
     * MyBatis获取参数值的各种情况
     * 1、mapper接口方法的参数为单个字面量类型
     * 可以通过${}和#{}以任意的字符串来获取参数值，但是需要${}外面要加一层''单引号
     * 2、mapper接口方法的参数为多个时
     * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储，
     *   1)以arg0, arg1...为键，以参数为值
     *   2)以param0, param1...为键，以参数为值
     * 因此只需要通过${}或#{}以键的方式访问值即可，但是需要${}外面要加一层''单引号
     * 3、若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中
     * 因此只需要通过${}或#{}以键的方式访问值即可，但是需要${}外面要加一层''单引号
     * 4、mapper接口方法的参数是实体类类型的参数
     * 因此只需要通过${}或#{}以属性的方式访问属性值即可，但是需要${}外面要加一层''单引号
     */

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(7, "李四", "22223333"));
        System.out.println(result);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "chy");
        map.put("pwd", "123435");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("chy", "123435");
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserByUserName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUserName("chy");
        System.out.println(user);
    }

    @Test
    public void testJDBC() throws Exception {
        String name = "张三";
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8";
        String user = "root";
        String password = "Yy@980519";
        Connection connection = DriverManager.getConnection(url, user, password);
        // PreparedStatement preparedStatement = connection.prepareStatement("select * from user where name = '" + name + "'");
        PreparedStatement ps = connection.prepareStatement("select * from user where name= ?");
        ps.setString(1, name);
    }
}
