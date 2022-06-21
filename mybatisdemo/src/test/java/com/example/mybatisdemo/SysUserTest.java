package com.example.mybatisdemo;

import com.example.mybatisdemo.entity.SysUser;
import com.example.mybatisdemo.mapper.SysUserMapper;
import com.example.mybatisdemo.service.SysUserService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
public class SysUserTest {
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysUserService sysUserService;

    @Test //单一查询
    void testSysUserGetById() {
        SysUser user = sysUserMapper.getById(1);
        System.out.println(user);
    }

    @Test //全部查询
    void testSysUserGetAll() {
        List<SysUser> all = sysUserMapper.getAll();
        System.out.println(all);
    }

    @Test //增加
    void testSysUserInsert() {
        int n = sysUserMapper.insert(new SysUser(10,"tom","111",1,0));
        System.out.println(n);
    }

    @Test //修改
    void testSysUserUpdate() {
        int n = sysUserMapper.update(new SysUser(10,"tom","123456",1,0));
        System.out.println(n);
    }

    @Test //删除
    void testSysUserDelete() {
        int n = sysUserMapper.delete(10);
        System.out.println(n);
    }

    @Test //登录
    void testSysUserLogin() {
        SysUser user = sysUserMapper.login("admin", "123456");
        System.out.println(user);
    }

    @Test //分页查询
    void testSysuserPaged() {
        PageInfo<SysUser> pageInfo = sysUserService.getPaged(1, 3);
        System.out.println(pageInfo);
    }
}
