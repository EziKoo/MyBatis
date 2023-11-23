package com.chy.mapper;

import com.chy.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: EziKoo
 * @Date: 2023/11/23 14:24
 * @Description: 定义员工的数据操作方法
 */

public interface EmployeeMapper {

    // 根据员工的姓名和工资查询员工信息
    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);

    List<Employee> queryTrim(@Param("name") String name, @Param("salary") Double salary);

    // 根据员工id更新员工的数据，我们要求 传入的name和salary不为空才更新
    int update(Employee employee);

    // 根据两个条件查询，如果姓名不为空使用姓名查询，如果姓名为空，薪水不为空就使用薪水查询！都为null 查询全部
    List<Employee> queryChoose(@Param("name") String name, @Param("salary") Double salary);

    // 根据id的批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);

    // 根据id的批量删除
    int deleteBatch(@Param("ids") List<Integer> ids);

    // 批量添加
    int insertBatch(@Param("list") List<Employee> employees);

    // 批量修改
    int updateBatch(@Param("list") List<Employee> employees);

}
