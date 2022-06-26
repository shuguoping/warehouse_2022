package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Clientinfo;


public interface ClientinfoMapper {

    int deleteByPrimaryKey(String id);

    int insert(Clientinfo record);

    int insertSelective(Clientinfo record);

    Clientinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Clientinfo record);

    int updateByPrimaryKey(Clientinfo record);

}
