package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrdersMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Orders record);
    int insertSelective(Orders record);
    Orders selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(Orders record);
    int updateByPrimaryKey(Orders record);

    List<Orders> search(@Param("code") String code, @Param("state") Integer state);
}
