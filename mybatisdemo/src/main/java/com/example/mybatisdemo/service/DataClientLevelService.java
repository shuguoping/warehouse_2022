package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Dataclientlevel;

public interface DataClientLevelService {
    Dataclientlevel selectByPrimaryKey(Long id);
    int insert(Dataclientlevel dataclientlevel);
    int updateByPrimaryKey(Dataclientlevel dataclientlevel);
    int deleteByPrimaryKey(Long id);
}
