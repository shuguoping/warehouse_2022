package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Clientserver;
import com.github.pagehelper.PageInfo;

public interface ClientServerService {

    PageInfo<Clientserver> getPaged(int pageNum, int pageSize, String clientcode, String title, Integer typeid);
    Clientserver selectByPrimaryKey(Long id);
    int insert(Clientserver clientserver);
    int updateByPrimaryKey(Clientserver clientserver );
    int deleteByPrimaryKey(Long id);
}
