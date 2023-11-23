package com.chy.test;

import com.chy.mapper.EmployeeMapper;
import com.chy.pojo.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @Date: 2023/11/23 19:26
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

    // 使用分页插件
    @Test
    public void test_01(){

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 调用之前，先设置分页数据（当前是第几页，每页显示多少个！）
        PageHelper.startPage(1,3);

        // TODO: 注意：不能将两条查询装到一个分页区
        List<Employee> list = mapper.queryList();

        // 将查询到的数据封装到一个PageInfo的分页实体类中（一共有多少页，一共有多少条等等）
        PageInfo<Employee> pageInfo = new PageInfo<>(list);

        // pageInfo获取分页的数据
        List<Employee> list1 = pageInfo.getList();
        System.out.println("list1 = " + list1);
        // 获取总页数
        int pages = pageInfo.getPages();
        System.out.println("pages = " + pages);
        // 获取总条数
        long total = pageInfo.getTotal();
        System.out.println("total = " + total);

        int pageNum = pageInfo.getPageNum();
        System.out.println("pageNum = " + pageNum);

        int pageSize = pageInfo.getPageSize();
        System.out.println("pageSize = " + pageSize);

        boolean hasNextPage = pageInfo.isHasNextPage();
        // ...

    }


    @AfterEach
    public void clean(){
        sqlSession.close();
    }

}
