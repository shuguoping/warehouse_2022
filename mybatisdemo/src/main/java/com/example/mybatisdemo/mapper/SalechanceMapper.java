package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Salechance;

import java.util.List;

public interface SalechanceMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Salechance record);
    int insertSelective(Salechance record);
    Salechance selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(Salechance record);
    int updateByPrimaryKey(Salechance record);

    List<Salechance> getAll();
}
