package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.Dataarea;
import com.github.pagehelper.PageInfo;

public interface DataAreaService {
    PageInfo<Dataarea> getPaged(int pageNum, int pageSize);

    Dataarea selectByPrimaryKey(Long id);
    int insert(Dataarea dataarea);
    int updateByPrimaryKey(Dataarea dataarea);
    int deleteByPrimaryKey(Long id);
}
