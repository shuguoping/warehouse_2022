package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Clientinfo;
import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.service.ClientinfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("clientinfo")
public class Clientinfocontroller {

    @Resource
    private ClientinfoService clientinfoService;

    @GetMapping("getPaged")
    public Result<PageInfo> getPaged(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "") String code,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "0") Integer custid){
        PageInfo<Clientinfo> pageInfo = clientinfoService.getPaged(pageNum, pageSize, code, name ,custid);
        return new Result<>(pageInfo);
    }

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
