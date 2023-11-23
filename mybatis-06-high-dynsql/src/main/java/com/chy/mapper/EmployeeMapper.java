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

}
