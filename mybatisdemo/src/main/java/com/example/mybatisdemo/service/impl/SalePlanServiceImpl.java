package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Saleplan;
import com.example.mybatisdemo.mapper.SaleplanMapper;
import com.example.mybatisdemo.service.SalePlanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SalePlanServiceImpl implements SalePlanService {
    //依赖注入
    @Resource
    private SaleplanMapper saleplanMapper;

    @Override
    public PageInfo<Saleplan> getPaged(int pageNum, int pageSize) {
        //对跟在其后的第一个查询语句进行分页
        PageHelper.startPage(pageNum,pageSize);
        //得到的就是分页后的数据，就不是查询所有的数据了
        List<Saleplan> list=saleplanMapper.getAll();
        //基于list集合数据，创建了一个分页信息对象
        PageInfo<Saleplan> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Saleplan selectByPrimaryKey(Long id) {
        return saleplanMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Saleplan saleplan) {
        return saleplanMapper.insert(saleplan);
    }

    @Override
    public int updateByPrimaryKey(Saleplan saleplan) {
        return saleplanMapper.updateByPrimaryKey(saleplan);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return saleplanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByChcId(Long chcid) {
        return saleplanMapper.deleteByChcId(chcid);
    }

}
