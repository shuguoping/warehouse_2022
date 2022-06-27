package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Clientinfo;
import com.example.mybatisdemo.entity.Salechance;
import com.example.mybatisdemo.mapper.ClientinfoMapper;
import com.example.mybatisdemo.service.ClientinfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ClientinfoServiceImpl implements ClientinfoService {
    //依赖注入
    @Resource
    private ClientinfoMapper clientinfoMapper;

    @Override
    public PageInfo<Clientinfo> getPaged(int pageNum, int pageSize, String code, String name, Integer custid)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<Clientinfo> list = clientinfoMapper.search("%"+code+"%",name+"%",custid);
        PageInfo<Clientinfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Clientinfo selectByPrimaryKey(String id) {
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
    public int deleteByPrimaryKey(String id) {
        return clientinfoMapper.deleteByPrimaryKey(id);
    }
}
