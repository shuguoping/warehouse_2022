package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Clientreprievelose;

/**
* @author 17190
* @description 针对表【clientreprievelose】的数据库操作Mapper
* @createDate 2022-06-21 23:33:26
* @Entity com.example.mybatisdemo.entity.Clientreprievelose
*/
public interface ClientreprieveloseMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Clientreprievelose record);

    int insertSelective(Clientreprievelose record);

    Clientreprievelose selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Clientreprievelose record);

    int updateByPrimaryKey(Clientreprievelose record);

}
