package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Clientinfo;

public interface ClientinfoService {
    Clientinfo selectByPrimaryKey(Long id);
    int insert(Clientinfo clientinfo);
    int updateByPrimaryKey(Clientinfo clientinfo );
    int deleteByPrimaryKey(Long id);
}
