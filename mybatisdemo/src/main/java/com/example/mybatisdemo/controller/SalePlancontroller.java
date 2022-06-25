package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.entity.Saleplan;
import com.example.mybatisdemo.service.SalePlanService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("saleplan")
public class SalePlancontroller {

    @Resource
    private SalePlanService salePlanService;

    @GetMapping("{id}")
    public Result<Saleplan> selectByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(salePlanService.selectByPrimaryKey(id));
    }

    @PostMapping
    public Result<Integer> insert(@RequestBody Saleplan saleplan){
        return new Result<>(salePlanService.insert(saleplan));
    }

    @PutMapping
    public Result<Integer> updateByPrimaryKey(@RequestBody Saleplan saleplan){
        return new Result<>(salePlanService.updateByPrimaryKey(saleplan));
    }

    @DeleteMapping("{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(salePlanService.deleteByPrimaryKey(id));
    }
}
