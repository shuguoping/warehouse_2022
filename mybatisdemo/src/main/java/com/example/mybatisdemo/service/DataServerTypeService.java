package com.example.mybatisdemo.service;


import com.example.mybatisdemo.entity.Dataclientlevel;
import com.example.mybatisdemo.entity.Dataservertype;
import com.github.pagehelper.PageInfo;

public interface DataServerTypeService {

    PageInfo<Dataservertype> getPaged(int pageNum, int pageSize);
    Dataservertype selectByPrimaryKey(Long id);
    int insert(Dataservertype dataservertype);
    int updateByPrimaryKey(Dataservertype dataservertype);
    int deleteByPrimaryKey(Long id);
}
