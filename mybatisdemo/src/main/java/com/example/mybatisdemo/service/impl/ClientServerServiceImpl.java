package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Clientserver;
import com.example.mybatisdemo.mapper.ClientserverMapper;
import com.example.mybatisdemo.service.ClientServerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ClientServerServiceImpl implements ClientServerService {
    //依赖注入
    @Resource
    private ClientserverMapper clientserverMapper;

    @Override
    public PageInfo<Clientserver> getPaged(int pageNum, int pageSize, String clientcode, String title, Integer typeid) {
        PageHelper.startPage(pageNum, pageSize);
        List<Clientserver> list = clientserverMapper.search("%"+clientcode+"%",title+"%",typeid);
        PageInfo<Clientserver> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Clientserver selectByPrimaryKey(Long id) {
        return clientserverMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Clientserver clientserver) {
        return clientserverMapper.insert(clientserver);
    }

    @Override
    public int updateByPrimaryKey(Clientserver clientserver) {
        return clientserverMapper.updateByPrimaryKey(clientserver);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return clientserverMapper.deleteByPrimaryKey(id);
    }
}
