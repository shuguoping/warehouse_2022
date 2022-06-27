package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Salechance;
import com.example.mybatisdemo.entity.SysUser;
import com.example.mybatisdemo.mapper.SalechanceMapper;
import com.example.mybatisdemo.mapper.SaleplanMapper;
import com.example.mybatisdemo.service.SaleChanceService;
import com.example.mybatisdemo.service.SalePlanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SaleChanceServiceImpl implements SaleChanceService {
    //依赖注入
    @Resource
    private SalechanceMapper salechanceMapper;

    @Resource
    private SaleplanMapper saleplanMapper;

    @Override
    public PageInfo<Salechance> getPaged(int pageNum, int pageSize,String custname,String title,String linkman) {
        PageHelper.startPage(pageNum, pageSize);
        List<Salechance> list = salechanceMapper.search("%"+custname+"%",title+"%",linkman);
        PageInfo<Salechance> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

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
