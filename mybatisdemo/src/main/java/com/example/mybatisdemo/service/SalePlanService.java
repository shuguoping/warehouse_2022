package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.SysUser;
import com.github.pagehelper.PageInfo;

public interface SalePlanService {
    PageInfo<SysUser> getPaged(int pageNum, int pageSize);
}
