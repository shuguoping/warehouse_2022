package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Orders;
import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("orders")
public class Orderscontroller {

    @Resource
    private OrdersService ordersService;

    @GetMapping("getPaged")
    public Result<PageInfo> getPaged(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "") String code,
            @RequestParam(defaultValue = "0") Integer state){
        PageInfo<Orders> pageInfo =ordersService.getPaged(pageNum, pageSize, code, state);
        return new Result<>(pageInfo);
    }

    @GetMapping("{id}")
    public Result<Orders> selectByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(ordersService.selectByPrimaryKey(id));
    }

    @PostMapping
    public Result<Integer> insert(@RequestBody Orders orders){
        return new Result<>(ordersService.insert(orders));
    }

    @PutMapping
    public Result<Integer> updateByPrimaryKey(@RequestBody Orders orders){
        return new Result<>(ordersService.updateByPrimaryKey(orders));
    }

    @DeleteMapping("{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(ordersService.deleteByPrimaryKey(id));
    }
}
