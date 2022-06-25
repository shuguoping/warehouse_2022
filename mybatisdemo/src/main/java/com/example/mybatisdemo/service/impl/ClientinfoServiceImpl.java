package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Clientinfo;
import com.example.mybatisdemo.mapper.ClientinfoMapper;
import com.example.mybatisdemo.service.ClientinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ClientinfoServiceImpl implements ClientinfoService {
    //依赖注入
    @Resource
    private ClientinfoMapper clientinfoMapper;

    @Override
    public Clientinfo selectByPrimaryKey(Long id) {
        return clientinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Clientinfo clientinfo) {
        return clientinfoMapper.insert(clientinfo);
    }

    @Override
    public int updateByPrimaryKey(Clientinfo clientinfo) {
        return clientinfoMapper.updateByPrimaryKey(clientinfo);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return clientinfoMapper.deleteByPrimaryKey(id);
    }
}
