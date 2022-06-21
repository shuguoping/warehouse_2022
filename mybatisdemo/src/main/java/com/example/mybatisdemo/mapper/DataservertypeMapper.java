package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Dataservertype;

/**
* @author 17190
* @description 针对表【dataservertype】的数据库操作Mapper
* @createDate 2022-06-21 22:45:02
* @Entity com.example.mybatisdemo.entity.Dataservertype
*/
public interface DataservertypeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Dataservertype record);

    int insertSelective(Dataservertype record);

    Dataservertype selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dataservertype record);

    int updateByPrimaryKey(Dataservertype record);

}
