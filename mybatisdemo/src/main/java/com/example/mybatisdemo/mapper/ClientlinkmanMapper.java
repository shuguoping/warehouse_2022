package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Clientlinkman;

/**
* @author 17190
* @description 针对表【clientlinkman】的数据库操作Mapper
* @createDate 2022-06-21 23:35:12
* @Entity com.example.mybatisdemo.entity.Clientlinkman
*/
public interface ClientlinkmanMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Clientlinkman record);

    int insertSelective(Clientlinkman record);

    Clientlinkman selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Clientlinkman record);

    int updateByPrimaryKey(Clientlinkman record);

}
