package com.example.mybatisdemo.service;


import com.example.mybatisdemo.entity.Dataservertype;

public interface DataServerTypeService {
    Dataservertype selectByPrimaryKey(Long id);
    int insert(Dataservertype dataservertype);
    int updateByPrimaryKey(Dataservertype dataservertype);
    int deleteByPrimaryKey(Long id);
}
