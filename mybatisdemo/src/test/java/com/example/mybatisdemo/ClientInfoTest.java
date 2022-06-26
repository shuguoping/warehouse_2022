package com.example.mybatisdemo;


import com.example.mybatisdemo.entity.Clientinfo;
import com.example.mybatisdemo.mapper.ClientinfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ClientInfoTest {
    @Resource
    private ClientinfoMapper clientinfoMapper;

    @Test
    void testclientinfoSelectByPrimaryKey(){
        Clientinfo clientinfo = clientinfoMapper.selectByPrimaryKey("KH011112001");
        System.out.println(clientinfo);
    }

    @Test //删除
    void testclientinfodelete(){
        int n = clientinfoMapper.deleteByPrimaryKey("KH444444444");
        System.out.println(n);
    }
}
