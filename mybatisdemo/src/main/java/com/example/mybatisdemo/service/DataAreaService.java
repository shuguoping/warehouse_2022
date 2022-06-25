package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Dataarea;

public interface DataAreaService {
    Dataarea selectByPrimaryKey(Long id);
    int insert(Dataarea dataarea);
    int updateByPrimaryKey(Dataarea dataarea);
    int deleteByPrimaryKey(Long id);
}
