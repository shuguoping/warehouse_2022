package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Clientinfo;
import com.example.mybatisdemo.entity.Dataarea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 17190
* @description 针对表【dataarea】的数据库操作Mapper
* @createDate 2022-06-21 23:24:47
* @Entity com.example.mybatisdemo.entity.Dataarea
*/
public interface DataareaMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Dataarea record);

    int insertSelective(Dataarea record);

    Dataarea selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dataarea record);

    int updateByPrimaryKey(Dataarea record);

    List<Dataarea> getAll();
}
