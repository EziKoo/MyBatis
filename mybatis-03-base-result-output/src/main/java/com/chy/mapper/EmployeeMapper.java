package com.chy.mapper;

import com.chy.pojo.Employee;

import java.util.List;
import java.util.Map;

/**
 * @Author: EziKoo
 * @Date: 2023/11/22 15:14
 * @Description: 规定数据库方法即可。
 */

public interface EmployeeMapper {

    // 如果是我们的DML语句(插入，修改，删除)
    int deleteById(Integer id);

    // 指定输出类型，查询语句
    // 根据员工的id查询员工的姓名
    String queryNameById(Integer id);

    // 根据员工的id查询员工的薪资
    Double querySalaryById(Integer id);

    // 返回单个自定义实体类型
    Employee queryById(Integer id);

    // 查询员工的最高工资和平均工资
    Map<String,Object> selectEmpNameAndMaxSalary();

    // 查询工资高于传入值的员工姓名们 200
    List<String> queryNamesBySalary(Double salary);

    // 查询全部员工信息
    List<Employee> queryAll();

}
