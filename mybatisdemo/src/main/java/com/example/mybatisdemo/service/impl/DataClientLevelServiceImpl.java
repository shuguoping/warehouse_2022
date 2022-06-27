package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Dataarea;
import com.example.mybatisdemo.entity.Dataclientlevel;
import com.example.mybatisdemo.mapper.DataclientlevelMapper;
import com.example.mybatisdemo.service.DataClientLevelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class DataClientLevelServiceImpl implements DataClientLevelService {
    //依赖注入
    @Resource
    private DataclientlevelMapper dataclientlevelMapper;

    @Override
    public PageInfo<Dataclientlevel> getPaged(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Dataclientlevel> list=dataclientlevelMapper.getAll();
        PageInfo<Dataclientlevel> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Dataclientlevel selectByPrimaryKey(Long id) {
        return dataclientlevelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Dataclientlevel dataclientlevel) {
        return dataclientlevelMapper.insert(dataclientlevel);
    }

    @Override
    public int updateByPrimaryKey(Dataclientlevel dataclientlevel) {
        return dataclientlevelMapper.updateByPrimaryKey(dataclientlevel);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dataclientlevelMapper.deleteByPrimaryKey(id);
    }
}
