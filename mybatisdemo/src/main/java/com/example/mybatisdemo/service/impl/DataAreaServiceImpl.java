package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Dataarea;
import com.example.mybatisdemo.mapper.DataareaMapper;
import com.example.mybatisdemo.service.DataAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class DataAreaServiceImpl implements DataAreaService {
    //依赖注入
    @Resource
    private DataareaMapper dataareaMapper;

    @Override
    public Dataarea selectByPrimaryKey(Long id) {
        return dataareaMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Dataarea dataarea) {
        return dataareaMapper.insert(dataarea);
    }

    @Override
    public int updateByPrimaryKey(Dataarea dataarea) {
        return dataareaMapper.updateByPrimaryKey(dataarea);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dataareaMapper.deleteByPrimaryKey(id);
    }
}
