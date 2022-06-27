package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Dataarea;
import com.example.mybatisdemo.entity.Dataclientlevel;

import java.util.List;

/**
* @author 17190
* @description 针对表【dataclientlevel】的数据库操作Mapper
* @createDate 2022-06-21 22:54:01
* @Entity com.example.mybatisdemo.entity.Dataclientlevel
*/
public interface DataclientlevelMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Dataclientlevel record);

    int insertSelective(Dataclientlevel record);

    Dataclientlevel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dataclientlevel record);

    int updateByPrimaryKey(Dataclientlevel record);

    List<Dataclientlevel> getAll();
}
