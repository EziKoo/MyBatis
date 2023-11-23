package com.chy.test;

import com.chy.mapper.EmployeeMapper;
import com.chy.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: EziKoo
 * @Date: 2023/11/23 10:22
 * @Description:
 */

public class MybatisTest {

    @Test
    public void test_01() throws IOException {
        // 1、读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        // 3、获取SqlSession对象 【自动开启事务 JDBC】 不会自动提交！ sqlSession.commit();
        // openSession(true); 自动开启事务，自动提交事务，不需要sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 4、获取代理mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setEmpName("麻瓜");
        employee.setEmpSalary(199.0);

        System.out.println(employee.getEmpId());
        System.out.println("-------------------");

        int rows = mapper.insertEmp(employee);
        System.out.println(employee.getEmpId());
        System.out.println("rows = " + rows);

        // 5、释放资源，提交事务
        // sqlSession.commit(); // DML语句
        sqlSession.close();

    }

}
