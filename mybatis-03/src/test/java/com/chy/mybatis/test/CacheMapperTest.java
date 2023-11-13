package com.chy.mybatis.test;

import com.chy.mybatis.mapper.CacheMapper;
import com.chy.mybatis.pojo.Emp;
import com.chy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {

    /*
        使一级缓存失效的四种情况：
            1) 不同的SqlSession对应不同的一级缓存
            1) 同一个SqlSession但是查询条件不同
            1) 同一个SqlSession两次查询期间执行了任何一次增删改操作
            1) 同一个SqlSession两次查询期间手动清空了缓存
     */

    @Test
    public void testOneCache(){
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByEid(1);
        System.out.println(emp1);

        // SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
        // CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        // Emp emp2 = mapper2.getEmpByEid(1);
        // System.out.println(emp2);

        // mapper1.insertEmp(new Emp(null,"abc",24,"男","666@qq.com"));

        sqlSession1.clearCache();

        Emp emp2 = mapper1.getEmpByEid(1);
        System.out.println(emp2);
    }


    @Test
    public void testTwoCache(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpByEid(1));
            sqlSession1.close();
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(1));
            sqlSession2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
