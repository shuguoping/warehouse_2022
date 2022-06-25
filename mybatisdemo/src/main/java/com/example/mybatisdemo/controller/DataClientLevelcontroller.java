package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Dataclientlevel;
import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.service.DataClientLevelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("dataclientlevel")
public class DataClientLevelcontroller {

    @Resource
    private DataClientLevelService dataClientLevelService;

    @GetMapping("{id}")
    public Result<Dataclientlevel> selectByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(dataClientLevelService.selectByPrimaryKey(id));
    }

    @PostMapping
    public Result<Integer> insert(@RequestBody Dataclientlevel dataclientlevel){
        return new Result<>(dataClientLevelService.insert(dataclientlevel));
    }

    @PutMapping
    public Result<Integer> updateByPrimaryKey(@RequestBody Dataclientlevel dataclientlevel){
        return new Result<>(dataClientLevelService.updateByPrimaryKey(dataclientlevel));
    }

    @DeleteMapping("{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(dataClientLevelService.deleteByPrimaryKey(id));
    }
}
