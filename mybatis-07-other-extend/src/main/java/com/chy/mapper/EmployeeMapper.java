package com.chy.mapper;

import com.chy.pojo.Employee;

import java.util.List;

/**
 * @Author: EziKoo
 * @Date: 2023/11/23 15:20
 * @Description: 定义方法
 */

public interface EmployeeMapper {

    List<Employee> queryList();

}
