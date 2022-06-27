package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Clientlinkman;
import com.example.mybatisdemo.entity.Clientreprievelose;
import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.service.ClientReprieveloseService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("clientreprievelose")
public class ClientReprieveLosecontroller {

    @Resource
    private ClientReprieveloseService clientReprieveloseService;

    @GetMapping("getPaged")
    public Result<PageInfo> getPaged(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "") String code,
            @RequestParam(defaultValue = "0") String reprievestep){
        PageInfo<Clientreprievelose> pageInfo = clientReprieveloseService.getPaged(pageNum, pageSize, code, reprievestep);
        return new Result<>(pageInfo);
    }

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
