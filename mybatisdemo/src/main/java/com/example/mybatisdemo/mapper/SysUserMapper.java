package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    //根据用户查询对象
    SysUser getById(int id);
    List<SysUser> getAll();
    int insert(SysUser sysUser);
    int update(SysUser sysUser);
    int delete(int id);
    SysUser login(@Param("userName") String userName, @Param("userPassword") String userPassword);
}
