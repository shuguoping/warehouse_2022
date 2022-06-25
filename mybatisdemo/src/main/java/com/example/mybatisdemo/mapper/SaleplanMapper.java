package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Saleplan;

import java.util.List;


public interface SaleplanMapper {
    int deleteByPrimaryKey(Long id);
    int deleteByChcId(Long chcid);
    int insert(Saleplan record);
    int insertSelective(Saleplan record);
    Saleplan selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(Saleplan record);
    int updateByPrimaryKey(Saleplan record);

    List<Saleplan> getAll();
    List<Saleplan> getByChanceId(Long chanceId);
}
