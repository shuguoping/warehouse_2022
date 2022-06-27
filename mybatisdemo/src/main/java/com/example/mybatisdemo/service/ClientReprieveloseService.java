package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Clientlinkman;
import com.example.mybatisdemo.entity.Clientreprievelose;
import com.github.pagehelper.PageInfo;

public interface ClientReprieveloseService {

    PageInfo<Clientreprievelose> getPaged(int pageNum, int pageSize, String code, String reprievestep);
    Clientreprievelose selectByPrimaryKey(Long id);
    int insert(Clientreprievelose clientreprievelose);
    int updateByPrimaryKey(Clientreprievelose clientreprievelose);
    int deleteByPrimaryKey(Long id);
}
