package com.chy.mybatis.test;

import com.chy.mybatis.mapper.EmpMapper;
import com.chy.mybatis.pojo.Emp;
import com.chy.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MBGTest {

    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            // 查询所有数据
            // List<Emp> list = mapper.selectByExample(null);
            // list.forEach(emp -> System.out.println(emp));

            // 根据条件查询
            // EmpExample example = new EmpExample();
            // example.createCriteria().andEmpNameEqualTo("李四").andAgeGreaterThanOrEqualTo(20);
            // example.or().andDidIsNotNull();
            // List<Emp> list = mapper.selectByExample(example);
            // list.forEach(emp -> System.out.println(emp));

            mapper.updateByPrimaryKeySelective(new Emp(1,"老六",90,null,"555@qq.com",3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
