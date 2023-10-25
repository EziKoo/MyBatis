package com.chy.mapper;

import com.chy.pojo.User;
import com.chy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    /**
     * SqlSession默认不自动提交事务，若需要自动提交事务
     * 可以使用SqlSessionFactory.openSession(true);
     */


    @Test
    /* 测试查询 */
    public void testSelectAll(){

        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper，获取mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 查询数据
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    /* 测试插入数据 */
    public void testInsert(){
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper，获取mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 插入数据
        userMapper.insertInfo();

        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    /* 测试修改数据 */
    public  void testUpdate(){
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper，获取mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 修改数据
        userMapper.updateUser();

        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    /* 测试删除数据 */
    public  void testDelete(){
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper，获取mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 删除数据
        userMapper.deleteUser();

        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    /* 测试单条数据 */
    public  void testUserById(){
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper，获取mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 查询数据
        User user = userMapper.getUserById();

        System.out.println(user);

        // 关闭SqlSession
        sqlSession.close();
    }
}
