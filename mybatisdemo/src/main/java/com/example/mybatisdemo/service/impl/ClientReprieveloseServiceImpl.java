package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Clientreprievelose;
import com.example.mybatisdemo.mapper.ClientreprieveloseMapper;
import com.example.mybatisdemo.service.ClientReprieveloseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ClientReprieveloseServiceImpl implements ClientReprieveloseService {
    //依赖注入
    @Resource
    private ClientreprieveloseMapper clientreprieveloseMapper;

    @Override
    public Clientreprievelose selectByPrimaryKey(Long id) {
        return clientreprieveloseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Clientreprievelose clientreprievelose) {
        return clientreprieveloseMapper.insert(clientreprievelose);
    }

    @Override
    public int updateByPrimaryKey(Clientreprievelose clientreprievelose) {
        return clientreprieveloseMapper.updateByPrimaryKey(clientreprievelose);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return clientreprieveloseMapper.deleteByPrimaryKey(id);
    }
}
