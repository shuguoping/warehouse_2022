package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Salechance;
import com.example.mybatisdemo.mapper.SalechanceMapper;
import com.example.mybatisdemo.mapper.SaleplanMapper;
import com.example.mybatisdemo.service.SaleChanceService;
import com.example.mybatisdemo.service.SalePlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SaleChanceServiceImpl implements SaleChanceService {
    //依赖注入
    @Resource
    private SalechanceMapper salechanceMapper;

    @Resource
    private SaleplanMapper saleplanMapper;

    @Override
    public Salechance selectByPrimaryKey(Long id) {
        return salechanceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Salechance salechance) {
        return salechanceMapper.insert(salechance);
    }

    @Override
    public int updateByPrimaryKey(Salechance salechance) {
        return salechanceMapper.updateByPrimaryKey(salechance);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return salechanceMapper.deleteByPrimaryKey(id) & saleplanMapper.deleteByChcId(id);
    }
}
