package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Saleplan;
import com.example.mybatisdemo.entity.SysUser;
import com.github.pagehelper.PageInfo;

public interface SalePlanService {
    //用户得到分页数据
    //pageNum第几页,pageSize每页最多几行
    PageInfo<Saleplan> getPaged(int pageNum, int pageSize, String todo, Integer chcid);

    Saleplan selectByPrimaryKey(Long id);
    int insert(Saleplan saleplan);
    int updateByPrimaryKey(Saleplan saleplan);
    int deleteByPrimaryKey(Long id);
    int deleteByChcId(Long chcid);
}
