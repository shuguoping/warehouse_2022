package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Salechance;
import com.github.pagehelper.PageInfo;


public interface SaleChanceService {

    PageInfo<Salechance> getPaged(int pageNum, int pageSize, String custname, String title,String linkman);

    Salechance selectByPrimaryKey(Long id);
    int insert(Salechance salechance);
    int updateByPrimaryKey(Salechance salechance);
    int deleteByPrimaryKey(Long id);
}
