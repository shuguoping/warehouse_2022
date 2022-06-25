package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.SysUser;
import com.github.pagehelper.PageInfo;

public interface SysUserService {
    //用户得到分页数据
    //pageNum第几页,pageSize每页最多几行
    PageInfo<SysUser> getPaged(int pageNum,int pageSize,String userName,Integer userRoleId);

    SysUser getById(int id);
    int insert(SysUser sysUser);
    int update(SysUser sysUser);
    int delete(int id);

    SysUser login(String username,String password);
}
