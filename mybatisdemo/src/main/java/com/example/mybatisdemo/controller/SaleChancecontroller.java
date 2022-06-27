package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.entity.Salechance;
import com.example.mybatisdemo.entity.Saleplan;
import com.example.mybatisdemo.entity.SysUser;
import com.example.mybatisdemo.service.SaleChanceService;
import com.example.mybatisdemo.service.SalePlanService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("salechance")
public class SaleChancecontroller {

    @Resource
    private SaleChanceService saleChanceService;

    @Resource
    private SalePlanService salePlanService;


    @GetMapping("getPaged")
    public Result<PageInfo> getPaged(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "") String custname,
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "0") String linkman){
        PageInfo<Salechance> pageInfo = saleChanceService.getPaged(pageNum, pageSize, custname, title, linkman);
        return new Result<>(pageInfo);
    }

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
