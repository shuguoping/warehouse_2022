package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Salechance;
import com.example.mybatisdemo.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalechanceMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Salechance record);
    int insertSelective(Salechance record);
    Salechance selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(Salechance record);
    int updateByPrimaryKey(Salechance record);

    List<Salechance> getAll();
    List<Salechance> search(@Param("custname") String custname, @Param("title") String title,@Param("linkman") String linkman,@Param("status") Integer status);
}
