package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Saleplan;

import java.util.List;


public interface SaleplanMapper {
    int deleteByPrimaryKey(Long id);
    List<Saleplan> getAll();
    int insert(Saleplan record);
    int insertSelective(Saleplan record);
    Saleplan selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(Saleplan record);
    int updateByPrimaryKey(Saleplan record);

    List<Saleplan> getByChanceId(Long chanceId);
}
