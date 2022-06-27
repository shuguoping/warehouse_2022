package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Orders;
import com.example.mybatisdemo.mapper.OrdersMapper;
import com.example.mybatisdemo.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class OrdersServiceImpl implements OrdersService {
    //依赖注入
    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public PageInfo<Orders> getPaged(int pageNum, int pageSize, String code, Integer state) {
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> list = ordersMapper.search("%"+code+"%",state);
        PageInfo<Orders> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    @Override
    public Orders selectByPrimaryKey(Long id) {
        return ordersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Orders orders) {
        return ordersMapper.insert(orders);
    }

    @Override
    public int updateByPrimaryKey(Orders orders) {
        return ordersMapper.updateByPrimaryKey(orders);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return ordersMapper.deleteByPrimaryKey(id);
    }
}
