package com.chy.mybatis.mapper;

import com.chy.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {


    /**
     *通过员工id查询员工信息
     */
    Emp getEmpByEid(@Param("eid") Integer eid);
}
