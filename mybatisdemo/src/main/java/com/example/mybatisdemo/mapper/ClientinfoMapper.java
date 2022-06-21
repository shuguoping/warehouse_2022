package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Clientinfo;

/**
* @author 17190
* @description 针对表【clientinfo】的数据库操作Mapper
* @createDate 2022-06-21 23:36:15
* @Entity com.example.mybatisdemo.entity.Clientinfo
*/
public interface ClientinfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Clientinfo record);

    int insertSelective(Clientinfo record);

    Clientinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Clientinfo record);

    int updateByPrimaryKey(Clientinfo record);

}
