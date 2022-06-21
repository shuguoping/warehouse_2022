package com.example.mybatisdemo;

import com.example.mybatisdemo.entity.Salechance;
import com.example.mybatisdemo.entity.Saleplan;
import com.example.mybatisdemo.entity.SysUser;
import com.example.mybatisdemo.mapper.SalechanceMapper;
import com.example.mybatisdemo.mapper.SaleplanMapper;
import com.example.mybatisdemo.mapper.SysUserMapper;
import com.example.mybatisdemo.service.SysUserService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MybatisdemoApplicationTests {
    //springboot生成SysUserMapper接口的实现类
    //同时注入到当前类中
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SalechanceMapper salechanceMapper;

    @Resource
    private SaleplanMapper saleplanMapper;

    @Resource
    private SysUserService sysUserService;


    @Test
    void testSysUserMapperGetById() {
        SysUser user = sysUserMapper.getById(1);
        System.out.println(user);
    }

    @Test
    void testSysUserMapperGetAll() {
        List<SysUser> all = sysUserMapper.getAll();
        System.out.println(all);
    }

    @Test
    void testSysUserMapperInsert() {
        int n = sysUserMapper.insert(new SysUser(10,"tom","111",1,0));
        System.out.println(n);
    }

    @Test
    void testSysUserMapperUpdate() {
        int n = sysUserMapper.update(new SysUser(10,"tom","123456",1,0));
        System.out.println(n);
    }

    @Test
    void testSysUserMapperDelete() {
        int n = sysUserMapper.delete(10);
        System.out.println(n);
    }

    @Test
    void testSysUserMapperLogin() {
        SysUser user = sysUserMapper.login("admin", "123456");
        System.out.println(user);
    }

    @Test
    void testSalechanceSelectByPrimaryKey() {
        Salechance salechance = salechanceMapper.selectByPrimaryKey(1L);
        System.out.println(salechance);
    }


    @Test
    void testSalechanceById() {
        Salechance salechance = salechanceMapper.selectByPrimaryKey(42L);
        List<Saleplan> plans = salechance.getPlans();
        for (Saleplan saleplan:plans) {
            System.out.println(saleplan.getId()+","+saleplan.getChcid()+","+saleplan.getTodo());
        }
    }


    @Test
    void testSysuserPaged() {
        PageInfo<SysUser> pageInfo = sysUserService.getPaged(1, 3);
        System.out.println(pageInfo);
    }
}
