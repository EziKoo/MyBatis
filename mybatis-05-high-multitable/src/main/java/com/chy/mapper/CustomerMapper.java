package com.chy.mapper;

import com.chy.pojo.Customer;

import java.util.List;

/**
 * @Author: EziKoo
 * @Date: 2023/11/23 14:02
 * @Description: 客户的方法
 */

public interface CustomerMapper {

    // 查询所有客户信息以及客户对应的订单信息
    List<Customer> queryList();

}
