package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Clientlinkman;
import com.example.mybatisdemo.entity.Clientreprievelose;
import com.example.mybatisdemo.mapper.ClientreprieveloseMapper;
import com.example.mybatisdemo.service.ClientReprieveloseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ClientReprieveloseServiceImpl implements ClientReprieveloseService {
    //依赖注入
    @Resource
    private ClientreprieveloseMapper clientreprieveloseMapper;

    @Override
    public PageInfo<Clientreprievelose> getPaged(int pageNum, int pageSize, String code, String reprievestep) {
        PageHelper.startPage(pageNum, pageSize);
        List<Clientreprievelose> list = clientreprieveloseMapper.search("%"+code+"%",reprievestep);
        PageInfo<Clientreprievelose> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

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
