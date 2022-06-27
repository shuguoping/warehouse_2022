package com.example.mybatisdemo.service;


import com.example.mybatisdemo.entity.Orders;
import com.github.pagehelper.PageInfo;

public interface OrdersService {

    PageInfo<Orders> getPaged(int pageNum, int pageSize, String code, Integer state);
    Orders selectByPrimaryKey(Long id);
    int insert(Orders orders);
    int updateByPrimaryKey(Orders orders);
    int deleteByPrimaryKey(Long id);
}
