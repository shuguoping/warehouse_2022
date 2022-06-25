package com.example.mybatisdemo;

import com.example.mybatisdemo.entity.Salechance;
import com.example.mybatisdemo.entity.Saleplan;
import com.example.mybatisdemo.mapper.SaleplanMapper;
import com.example.mybatisdemo.service.SalePlanService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
public class SalePlanTest {
    @Resource
    private SaleplanMapper saleplanMapper;

    @Resource
    private SalePlanService salePlanService;

    @Test //单一查询
    void testSalePlanGetById1() {
        Saleplan saleplan = saleplanMapper.selectByPrimaryKey(1L);
        System.out.println(saleplan);
    }

    @Test //单一查询
    void testSalePlanGetById2() {
        Saleplan saleplan = saleplanMapper.selectByPrimaryKey(1L);
        System.out.println(saleplan.getId()+","+saleplan.getChcid()+","+saleplan.getTodo());
    }

    @Test //全部查询
    void testSalePlanGetAll1() {
        List<Saleplan> all = saleplanMapper.getAll();
        for (Saleplan saleplan: all) {
            System.out.println(saleplan.getId()+","+
                               saleplan.getChcid()+","+
                               saleplan.getTodo()+","+
                               saleplan.getResult());
        }
    }

    @Test //全部查询
    void testSalePlanGetAll2() {
        List<Saleplan> all = saleplanMapper.getAll();
        System.out.println(all);
    }

    @Test //插入
    void testSalePlanInsert() {
        int n = saleplanMapper.insert(new Saleplan(4,100,"与客户交流","",null));
        System.out.println(n);
    }

    @Test //更新
    void testSalePlanUpdate() {
        int n = saleplanMapper.updateByPrimaryKey(new Saleplan(4,5,"与客户喝茶","",null));
        System.out.println(n);
    }

    @Test //单一查询
    void testSalePlanDelete() {
        int n = saleplanMapper.deleteByPrimaryKey(4L);
        System.out.println(n);
    }

    @Test //分页查询
    void testSalePlanPaged1() {
        PageInfo<Saleplan> pageInfo = salePlanService.getPaged(1, 3);
        System.out.println("pageNum="+pageInfo.getPageNum()+
                           ",pageSize="+pageInfo.getPageSize()+
                ",startRow="+pageInfo.getStartRow()+
                ",endRow="+pageInfo.getEndRow()+
                ",total="+pageInfo.getTotal()+
                ",pages="+pageInfo.getPages());
    }

    @Test //分页查询
    void testSalePlanPaged2() {
        PageInfo<Saleplan> pageInfo = salePlanService.getPaged(1, 3);
        System.out.println(pageInfo);
    }

}
