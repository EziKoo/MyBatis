package com.chy.test;

import com.chy.mapper.EmployeeMapper;
import com.chy.mapper.TeacherMapper;
import com.chy.pojo.Employee;
import com.chy.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

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


    @Test
    public void test_02() throws IOException {
        // 1、读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        // 3、获取SqlSession对象 【自动开启事务 JDBC】 不会自动提交！ sqlSession.commit();
        // openSession(true); 自动开启事务，自动提交事务，不需要sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 4、获取代理mapper对象
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = new Teacher();
        teacher.settName("呵呵呵2");
        // 自己维护主键
        // String id = UUID.randomUUID().toString().replaceAll("-", "");
        // teacher.settId(id);

        System.out.println(teacher.gettId());

        int i = mapper.insertTeacher(teacher);

        System.out.println(teacher.gettId());
        System.out.println("i = " + i);

        // 5、释放资源，提交事务
        sqlSession.close();

    }

}
