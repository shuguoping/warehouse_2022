package com.example.mybatisdemo.service;


import com.example.mybatisdemo.entity.Dataclientlevel;
import com.github.pagehelper.PageInfo;

public interface DataClientLevelService {
    PageInfo<Dataclientlevel> getPaged(int pageNum, int pageSize);

    Dataclientlevel selectByPrimaryKey(Long id);
    int insert(Dataclientlevel dataclientlevel);
    int updateByPrimaryKey(Dataclientlevel dataclientlevel);
    int deleteByPrimaryKey(Long id);
}
