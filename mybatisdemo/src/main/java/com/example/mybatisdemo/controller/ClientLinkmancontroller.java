package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.Clientinfo;
import com.example.mybatisdemo.entity.Clientlinkman;
import com.example.mybatisdemo.entity.Result;
import com.example.mybatisdemo.service.ClientLinkmanService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("clientlinkman")
public class ClientLinkmancontroller {

    @Resource
    private ClientLinkmanService clientLinkmanService;

    @GetMapping("getPaged")
    public Result<PageInfo> getPaged(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "") String code,
            @RequestParam(defaultValue = "0") String linkmanname){
        PageInfo<Clientlinkman> pageInfo = clientLinkmanService.getPaged(pageNum, pageSize, code, linkmanname);
        return new Result<>(pageInfo);
    }

    @GetMapping("{id}")
    public Result<Clientlinkman> selectByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(clientLinkmanService.selectByPrimaryKey(id));
    }

    @PostMapping
    public Result<Integer> insert(@RequestBody Clientlinkman clientlinkman){
        return new Result<>(clientLinkmanService.insert(clientlinkman));
    }

    @PutMapping
    public Result<Integer> updateByPrimaryKey(@RequestBody Clientlinkman clientlinkman){
        return new Result<>(clientLinkmanService.updateByPrimaryKey(clientlinkman));
    }

    @DeleteMapping("{id}")
    public Result<Integer> deleteByPrimaryKey(@PathVariable("id") Long id){
        return new Result<>(clientLinkmanService.deleteByPrimaryKey(id));
    }
}
