package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Clientserver;

/**
* @author 17190
* @description 针对表【clientserver】的数据库操作Mapper
* @createDate 2022-06-21 23:32:20
* @Entity com.example.mybatisdemo.entity.Clientserver
*/
public interface ClientserverMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Clientserver record);

    int insertSelective(Clientserver record);

    Clientserver selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Clientserver record);

    int updateByPrimaryKey(Clientserver record);

}
