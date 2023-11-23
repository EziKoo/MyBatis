package com.chy.test;

import com.chy.mapper.UserMapper;
import com.chy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: EziKoo
 * @Date: 2023/11/23 11:34
 * @Description:
 */

public class MybatisTest {

    private SqlSession sqlSession;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach // 每次走测试方法之前，先走的初始化方法
    public void init() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @After // 每次走测试方法之后调用方法
    public void clean(){
        sqlSession.close();
    }

    @Test
    public void testInsert() throws IOException {

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setPassword("12315");
        int insert = mapper.insert(user);
        System.out.println("insert = " + insert);
    }
    @Test
    public void testUpdate(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int delete = mapper.delete(1);
        System.out.println("delete = " + delete);
    }
    @Test
    public void testDelete(){

    }
    @Test
    public void testSelectById(){

    }
    @Test
    public void testSelectAll(){

    }

}
