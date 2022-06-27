package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Clientinfo;
import com.example.mybatisdemo.entity.Clientlinkman;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ClientlinkmanMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Clientlinkman record);

    int insertSelective(Clientlinkman record);

    Clientlinkman selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Clientlinkman record);

    int updateByPrimaryKey(Clientlinkman record);

    List<Clientlinkman> search(@Param("code") String code, @Param("linkmanname") String linkmanname);
}
