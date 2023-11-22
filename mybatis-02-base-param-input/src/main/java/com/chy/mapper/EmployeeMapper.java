package com.chy.mapper;

import com.chy.pojo.Employee;

/**
 * @Author: EziKoo
 * @Date: 2023/11/22 15:14
 * @Description: 规定数据库方法即可。
 */

public interface EmployeeMapper {

    // 根据id查询员工信息
    Employee queryById(Integer id);

    // 根据id删除员工信息
    Employee deleteById(Integer id);

}
