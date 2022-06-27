package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Clientinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ClientinfoMapper {

    int deleteByPrimaryKey(String id);

    int insert(Clientinfo record);

    int insertSelective(Clientinfo record);

    Clientinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Clientinfo record);

    int updateByPrimaryKey(Clientinfo record);

    List<Clientinfo> search(@Param("code") String code, @Param("name") String name, @Param("custid") Integer custid);

}
