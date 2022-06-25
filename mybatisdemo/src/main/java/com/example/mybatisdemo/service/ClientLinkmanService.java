package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Clientlinkman;

public interface ClientLinkmanService {
    Clientlinkman selectByPrimaryKey(Long id);
    int insert(Clientlinkman clientlinkman);
    int updateByPrimaryKey(Clientlinkman clientlinkman);
    int deleteByPrimaryKey(Long id);
}
