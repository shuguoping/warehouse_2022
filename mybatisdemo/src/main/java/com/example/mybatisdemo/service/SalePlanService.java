package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Saleplan;
import com.github.pagehelper.PageInfo;

public interface SalePlanService {
    //用户得到分页数据
    //pageNum第几页,pageSize每页最多几行
    PageInfo<Saleplan> getPaged(int pageNum, int pageSize);
}
