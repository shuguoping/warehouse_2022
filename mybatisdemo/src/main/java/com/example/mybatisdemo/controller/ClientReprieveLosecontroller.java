package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Clientreprievelose;
import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.service.ClientReprieveloseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("clientreprievelose")
public class ClientReprieveLosecontroller {

    @Resource
    private ClientReprieveloseService clientReprieveloseService;

    @GetMapping("{id}")
    public Result<Clientreprievelose> selectByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(clientReprieveloseService.selectByPrimaryKey(id));
    }

    @PostMapping
    public Result<Integer> insert(@RequestBody Clientreprievelose clientreprievelose){
        return new Result<>(clientReprieveloseService.insert(clientreprievelose));
    }

    @PutMapping
    public Result<Integer>  updateByPrimaryKey(@RequestBody Clientreprievelose clientreprievelose){
        return new Result<>(clientReprieveloseService.updateByPrimaryKey(clientreprievelose));
    }

    @DeleteMapping("{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(clientReprieveloseService.deleteByPrimaryKey(id));
    }
}
