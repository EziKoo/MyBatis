package com.chy.mapper;

import com.chy.pojo.Order;

/**
 * @Author: EziKoo
 * @Date: 2023/11/23 13:44
 * @Description: 订单方法
 */

public interface OrderMapper {

    // 根据id查询订单信息和订单对应的客户
    Order queryOrderById(Integer id);

}
