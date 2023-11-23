package com.chy.test;

import com.chy.mapper.EmployeeMapper;
import com.chy.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Author: EziKoo
 * @Date: 2023/11/23 14:37
 * @Description:
 */

public class MybatisTest {

    private SqlSession sqlSession;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach
    public void init() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    // 测试where if 标签的
    @Test
    public void test_01(){
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.query(null,101.0);
        System.out.println("employees = " + employees);
    }


    @AfterEach
    public void clean(){
        sqlSession.close();
    }

}
