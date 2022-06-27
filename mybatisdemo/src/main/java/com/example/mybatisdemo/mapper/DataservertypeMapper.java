package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Dataclientlevel;
import com.example.mybatisdemo.entity.Dataservertype;

import java.util.List;


public interface DataservertypeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Dataservertype record);

    int insertSelective(Dataservertype record);

    Dataservertype selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dataservertype record);

    int updateByPrimaryKey(Dataservertype record);

    List<Dataservertype> getAll();

}
