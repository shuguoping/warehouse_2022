package com.example.mybatisdemo;

import com.example.mybatisdemo.entity.Saleplan;
import com.example.mybatisdemo.mapper.SaleplanMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class SalePlanTest {
    @Resource
    private SaleplanMapper saleplanMapper;

    /*@Test //单一查询，在不关联时可使用
    void testSalePlanMapperGetById() {
        Saleplan saleplan = saleplanMapper.selectByPrimaryKey(1L);
        System.out.println(saleplan);
    }*/
}
