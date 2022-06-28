package com.example.mybatisdemo;


import com.example.mybatisdemo.entity.Salechance;
import com.example.mybatisdemo.entity.Saleplan;
import com.example.mybatisdemo.mapper.SalechanceMapper;
import com.example.mybatisdemo.mapper.SaleplanMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SaleChanceTest {
    @Resource
    private SalechanceMapper salechanceMapper;

    @Resource
    private SaleplanMapper saleplanMapper;

    @Test //单一查询
    void testSalechanceSelectByPrimaryKey() {
        Salechance salechance = salechanceMapper.selectByPrimaryKey(1L);
        System.out.println(salechance);
    }

    @Test //全部查询
    void testSalechanceGetAll1() {
        List<Salechance> all = salechanceMapper.getAll();
        for (Salechance salechance: all) {
            System.out.println(salechance.getId()+"," +
                               salechance.getSource()+","+
                               salechance.getCustname()+","+
                               salechance.getTitle()+","+
                               salechance.getRate()+","+
                               salechance.getLinkman()+","+
                               salechance.getTel()+","+
                               salechance.getDesc()+","+
                               salechance.getCreateid()+","+
                               salechance.getCreatedate()+","+
                               salechance.getDueid()+","+
                               salechance.getDuedate()+","+
                               salechance.getStatus());
        }
    }

    @Test //全部查询
    void testSalechanceGetAll2() {
        List<Salechance> all = salechanceMapper.getAll();
        System.out.println(all);
    }

    @Test //增加
    void testSalechanceinsert(){
        int n = salechanceMapper.insert(new Salechance(100,"同学","APPLE Inc.","WWDC",100,"Tim Cook","1234567890","Let's go APPLE",100,"2022-06-20",100,"2022-07-01",1,null));
        System.out.println(n);
    }

    @Test //更新
    void testSalechanceupdate(){
        int n = salechanceMapper.updateByPrimaryKey(new Salechance(100,"student","APPLE Inc.","WWDC",100,"Tim Cook","1234567890","Let's go APPLE",80,"2022-06-20",100,"2022-07-01",1,null));
        System.out.println(n);
    }

    @Test //删除
    void testSalechancedelete(){
        int n = salechanceMapper.deleteByPrimaryKey(100L);
        int a = saleplanMapper.deleteByChcId(100L);
        System.out.println(n);
        System.out.println(a);
    }

    @Test  //与saleplan关联查询
    void testSalechanceById() {
        Salechance salechance = salechanceMapper.selectByPrimaryKey(42L);
        System.out.println(salechance);
        List<Saleplan> plans = salechance.getPlans();
        for (Saleplan saleplan:plans) {
            System.out.println(saleplan.getId()+","+saleplan.getChcid()+","+saleplan.getTodo());
        }
    }

}
