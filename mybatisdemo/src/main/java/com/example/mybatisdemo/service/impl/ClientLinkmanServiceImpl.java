package com.example.mybatisdemo.service.impl;


import com.example.mybatisdemo.entity.Clientlinkman;
import com.example.mybatisdemo.mapper.ClientlinkmanMapper;
import com.example.mybatisdemo.service.ClientLinkmanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ClientLinkmanServiceImpl implements ClientLinkmanService {
    //依赖注入
    @Resource
    private ClientlinkmanMapper clientlinkmanMapper;

    @Override
    public PageInfo<Clientlinkman> getPaged(int pageNum, int pageSize, String code, String linkmanname) {
        PageHelper.startPage(pageNum, pageSize);
        List<Clientlinkman> list = clientlinkmanMapper.search("%"+code+"%",linkmanname);
        PageInfo<Clientlinkman> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Clientlinkman selectByPrimaryKey(Long id) {
        return clientlinkmanMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Clientlinkman clientlinkman) {
        return clientlinkmanMapper.insert(clientlinkman);
    }

    @Override
    public int updateByPrimaryKey(Clientlinkman clientlinkman) {
        return clientlinkmanMapper.updateByPrimaryKey(clientlinkman);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return clientlinkmanMapper.deleteByPrimaryKey(id);
    }
}
