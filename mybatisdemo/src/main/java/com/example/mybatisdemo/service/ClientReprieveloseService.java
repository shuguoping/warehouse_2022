package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Clientreprievelose;

public interface ClientReprieveloseService {
    Clientreprievelose selectByPrimaryKey(Long id);
    int insert(Clientreprievelose clientreprievelose);
    int updateByPrimaryKey(Clientreprievelose clientreprievelose);
    int deleteByPrimaryKey(Long id);
}
