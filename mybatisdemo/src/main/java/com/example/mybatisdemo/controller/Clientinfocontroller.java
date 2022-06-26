package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Clientinfo;
import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.service.ClientinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("clientinfo")
public class Clientinfocontroller {

    @Resource
    private ClientinfoService clientinfoService;


    @GetMapping("{id}")
    public Result<Clientinfo> selectByPrimaryKey(@PathVariable("id") String id){
        return new Result<>(clientinfoService.selectByPrimaryKey(id));
    }

    @PostMapping
    public Result<Integer> insert(@RequestBody Clientinfo clientinfo){
        return new Result<>(clientinfoService.insert(clientinfo));
    }

    @PutMapping
    public Result<Integer>  updateByPrimaryKey(@RequestBody Clientinfo clientinfo){
        return new Result<>(clientinfoService. updateByPrimaryKey(clientinfo));
    }

    @DeleteMapping("{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") String id){
        return new Result<>(clientinfoService.deleteByPrimaryKey(id));
    }

}
