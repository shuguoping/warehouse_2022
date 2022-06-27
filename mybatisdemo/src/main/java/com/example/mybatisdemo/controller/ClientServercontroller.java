package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Clientserver;
import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.service.ClientServerService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("clientserver")
public class ClientServercontroller {

    @Resource
    private ClientServerService clientServerService;


    @GetMapping("getPaged")
    public Result<PageInfo> getPaged(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "") String clientcode,
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "0") Integer typeid){
        PageInfo<Clientserver> pageInfo = clientServerService.getPaged(pageNum, pageSize, clientcode, title, typeid);
        return new Result<>(pageInfo);
    }

    @GetMapping("{id}")
    public Result<Clientserver> selectByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(clientServerService.selectByPrimaryKey(id));
    }

    @PostMapping
    public Result<Integer> insert(@RequestBody Clientserver clientserver){
        return new Result<>(clientServerService.insert(clientserver));
    }

    @PutMapping
    public Result<Integer> updateByPrimaryKey(@RequestBody Clientserver clientserver){
        return new Result<>(clientServerService.updateByPrimaryKey(clientserver));
    }

    @DeleteMapping("{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(clientServerService.deleteByPrimaryKey(id));
    }
}
