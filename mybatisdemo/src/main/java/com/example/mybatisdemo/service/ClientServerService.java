package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Clientserver;

public interface ClientServerService {
    Clientserver selectByPrimaryKey(Long id);
    int insert(Clientserver clientserver);
    int updateByPrimaryKey(Clientserver clientserver );
    int deleteByPrimaryKey(Long id);
}
