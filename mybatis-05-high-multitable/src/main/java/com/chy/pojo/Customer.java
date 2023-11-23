package com.chy.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Author: EziKoo
 * @Date: 2023/11/23 13:41
 * @Description: 客户实体类
 */

@Data
public class Customer {

    private Integer customerId;

    private String customerName;

    // 一个客户对应多个订单
    // 对多：装对应类型的集合
    private List<Order> orderList;

}
