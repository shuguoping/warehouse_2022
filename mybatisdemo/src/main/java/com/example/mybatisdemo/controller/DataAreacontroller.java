package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Dataarea;
import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.service.DataAreaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("dataarea")
public class DataAreacontroller {

    @Resource
    private DataAreaService dataAreaService;

    @GetMapping("{id}")
    public Result<Dataarea> selectByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(dataAreaService.selectByPrimaryKey(id));
    }

    @PostMapping
    public Result<Integer> insert(@RequestBody Dataarea dataarea){
        return new Result<>(dataAreaService.insert(dataarea));
    }

    @PutMapping
    public Result<Integer>  updateByPrimaryKey(@RequestBody Dataarea dataarea){
        return new Result<>(dataAreaService. updateByPrimaryKey(dataarea));
    }

    @DeleteMapping("{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(dataAreaService.deleteByPrimaryKey(id));
    }
}
