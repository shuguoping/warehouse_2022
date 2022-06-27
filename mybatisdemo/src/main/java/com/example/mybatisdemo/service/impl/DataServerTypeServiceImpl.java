package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Dataclientlevel;
import com.example.mybatisdemo.entity.Dataservertype;
import com.example.mybatisdemo.mapper.DataservertypeMapper;
import com.example.mybatisdemo.service.DataServerTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class DataServerTypeServiceImpl implements DataServerTypeService {
    //依赖注入
    @Resource
    private DataservertypeMapper dataservertypeMapper;

    @Override
    public PageInfo<Dataservertype> getPaged(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Dataservertype> list=dataservertypeMapper.getAll();
        PageInfo<Dataservertype> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

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
