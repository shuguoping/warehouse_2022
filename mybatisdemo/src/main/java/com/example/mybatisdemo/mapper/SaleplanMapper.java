package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Saleplan;
import com.example.mybatisdemo.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SaleplanMapper {
    int deleteByPrimaryKey(Long id);
    int deleteByChcId(Long chcid);
    int insert(Saleplan record);
    int insertSelective(Saleplan record);
    Saleplan selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(Saleplan record);
    int updateByPrimaryKey(Saleplan record);

    List<Saleplan> getAll();
    List<Saleplan> getByChanceId(Long chanceId);
    List<Saleplan> search(@Param("todo") String todo, @Param("chcid") Integer chcid);
}
