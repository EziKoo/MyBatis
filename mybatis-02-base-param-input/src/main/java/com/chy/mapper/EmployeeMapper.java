package com.chy.mapper;

import com.chy.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: EziKoo
 * @Date: 2023/11/22 15:14
 * @Description: 规定数据库方法即可。
 */

public interface EmployeeMapper {

    // 根据id查询员工信息
    Employee queryById(Integer id);

    // 根据id删除员工信息
    int deleteById(Integer id);

    // 根据工资查询员工信息
    List<Employee> queryBySalary(Double salary);

    // 插入员工数据 【实体对象】
    int insertEmp(Employee employee);

    // 根据员工姓名和工资查询员工信息
    List<Employee> queryByNameAndSalary(@Param("name") String name, @Param("salary") Double salary);


}
