package com.chy.mybatis.test;

import com.chy.mybatis.mapper.DynamicSQLMapper;
import com.chy.mybatis.pojo.Emp;
import com.chy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DynamicSQLMapperTest {

    /**
     * 动态SQL:
     *      1、if：根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
     */

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "张三", null, null, null));
        System.out.println(list);
    }

}
