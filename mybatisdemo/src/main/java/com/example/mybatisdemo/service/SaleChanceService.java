package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Salechance;


public interface SaleChanceService {

    Salechance selectByPrimaryKey(Long id);
    int insert(Salechance salechance);
    int updateByPrimaryKey(Salechance salechance);
    int deleteByPrimaryKey(Long id);
}
