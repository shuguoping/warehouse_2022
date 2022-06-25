package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Clientserver;
import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.service.ClientServerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("clientserver")
public class ClientServercontroller {

    @Resource
    private ClientServerService clientServerService;

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
