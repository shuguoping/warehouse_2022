package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Clientinfo;
import com.github.pagehelper.PageInfo;

public interface ClientinfoService {
    PageInfo<Clientinfo> getPaged(int pageNum, int pageSize, String code, String name);

    Clientinfo selectByPrimaryKey(String id);
    int insert(Clientinfo clientinfo);
    int updateByPrimaryKey(Clientinfo clientinfo );
    int deleteByPrimaryKey(String id);
}
