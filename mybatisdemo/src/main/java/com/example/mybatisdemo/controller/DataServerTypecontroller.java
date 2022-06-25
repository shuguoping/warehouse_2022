package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Dataservertype;
import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.service.DataServerTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("dataservertype")
public class DataServerTypecontroller {

    @Resource
    private DataServerTypeService dataServerTypeService;

    @GetMapping("{id}")
    public Result<Dataservertype> selectByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(dataServerTypeService.selectByPrimaryKey(id));
    }

    @PostMapping
    public Result<Integer> insert(@RequestBody Dataservertype dataservertype){
        return new Result<>(dataServerTypeService.insert(dataservertype));
    }

    @PutMapping
    public Result<Integer> updateByPrimaryKey(@RequestBody Dataservertype dataservertype){
        return new Result<>(dataServerTypeService. updateByPrimaryKey(dataservertype));
    }

    @DeleteMapping("{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(dataServerTypeService.deleteByPrimaryKey(id));
    }
}
