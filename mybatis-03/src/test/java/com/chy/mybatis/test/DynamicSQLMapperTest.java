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
     *      2、where：
     *          当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或or去掉
     *          当where标签中没有内容时，此时where标签没有任何效果
     *          注意：where标签不能将其中内容后面多余的and或or去掉
     */

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, null, 23, null, null));
        System.out.println(list);
    }

}
