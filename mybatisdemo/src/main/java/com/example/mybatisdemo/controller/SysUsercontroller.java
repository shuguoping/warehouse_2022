package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.entity.SysUser;
import com.example.mybatisdemo.service.SysUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("sysuser")
public class SysUsercontroller {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("getPaged")
    public Result<PageInfo> getPaged
            (@RequestParam(defaultValue = "1") int pageNum,
             @RequestParam(defaultValue = "3") int pageSize) {
        PageInfo<SysUser> pageInfo =sysUserService.getPaged(pageNum, pageSize);
        return new Result<>(pageInfo);
    }

    @GetMapping("{id}")
    public Result<SysUser> getById(@PathVariable("id") int id){
        return new Result<>(sysUserService.getById(id));
    }

    @PostMapping
    public Result<Integer> insert(@RequestBody SysUser sysUser){
        return new Result<>(sysUserService.insert(sysUser));
    }

    @PutMapping
    public Result<Integer> update(@RequestBody SysUser sysUser){
        return new Result<>(sysUserService.update(sysUser));
    }

    @DeleteMapping("{id}")
    public Result<Integer> delete(@PathVariable("id") int id){
        return new Result<>(sysUserService.delete(id));
    }

    //处理器，用来处理请求
    @GetMapping("hello")
    public String hello(){
        return "hello world!!!";
    }
}
