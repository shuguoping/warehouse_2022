package com.example.mybatisdemo.service;


import com.example.mybatisdemo.entity.Orders;

public interface OrdersService {
    Orders selectByPrimaryKey(Long id);
    int insert(Orders orders);
    int updateByPrimaryKey(Orders orders);
    int deleteByPrimaryKey(Long id);
}
