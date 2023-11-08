package com.chy.mybatis.mapper;

import com.chy.mybatis.pojo.Emp;

import java.util.List;

public interface EmpMapper {

    /**
     * 查询所有的员工信息
     */
    List<Emp> getAllEmp();

}
