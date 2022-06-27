package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Clientlinkman;
import com.github.pagehelper.PageInfo;

public interface ClientLinkmanService {
    PageInfo<Clientlinkman> getPaged(int pageNum, int pageSize, String code, String linkmanname);
    Clientlinkman selectByPrimaryKey(Long id);
    int insert(Clientlinkman clientlinkman);
    int updateByPrimaryKey(Clientlinkman clientlinkman);
    int deleteByPrimaryKey(Long id);
}
