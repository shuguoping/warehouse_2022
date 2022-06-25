package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Clientinfo;


public interface ClientinfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Clientinfo record);

    int insertSelective(Clientinfo record);

    Clientinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Clientinfo record);

    int updateByPrimaryKey(Clientinfo record);

}
