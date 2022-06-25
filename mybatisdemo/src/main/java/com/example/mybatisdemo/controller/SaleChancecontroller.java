package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.entity.Salechance;
import com.example.mybatisdemo.entity.Saleplan;
import com.example.mybatisdemo.service.SaleChanceService;
import com.example.mybatisdemo.service.SalePlanService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("salechance")
public class SaleChancecontroller {

    @Resource
    private SaleChanceService saleChanceService;

    @Resource
    private SalePlanService salePlanService;

    @GetMapping("{id}")
    public Result<Salechance> selectByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(saleChanceService.selectByPrimaryKey(id));
    }

    @PostMapping
    public Result<Integer> insert(@RequestBody Salechance salechance){
        return new Result<>(saleChanceService.insert(salechance));
    }

    @PutMapping
    public Result<Integer> updateByPrimaryKey(@RequestBody Salechance salechance){
        return new Result<>(saleChanceService.updateByPrimaryKey(salechance));
    }

    @DeleteMapping("{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(saleChanceService.deleteByPrimaryKey(id) & salePlanService.deleteByChcId(id));
    }
}
