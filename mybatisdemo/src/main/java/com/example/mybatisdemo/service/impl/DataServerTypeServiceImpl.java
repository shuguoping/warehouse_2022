package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Dataservertype;
import com.example.mybatisdemo.mapper.DataservertypeMapper;
import com.example.mybatisdemo.service.DataServerTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class DataServerTypeServiceImpl implements DataServerTypeService {
    //依赖注入
    @Resource
    private DataservertypeMapper dataservertypeMapper;

    @Override
    public Dataservertype selectByPrimaryKey(Long id) {
        return dataservertypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Dataservertype dataservertype) {
        return dataservertypeMapper.insert(dataservertype);
    }

    @Override
    public int updateByPrimaryKey(Dataservertype dataservertype) {
        return dataservertypeMapper.updateByPrimaryKey(dataservertype);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dataservertypeMapper.deleteByPrimaryKey(id);
    }
}
