package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.SysUser;
import com.example.mybatisdemo.mapper.SysUserMapper;
import com.example.mybatisdemo.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    //依赖注入
    @Resource

    private SysUserMapper sysUserMapper;

    @Override
    public PageInfo<SysUser> getPaged(int pageNum, int pageSize) {
        //对跟在其后的第一个查询语句进行分页
        PageHelper.startPage(pageNum,pageSize);
        //得到的就是分页后的数据，就不是查询所有的数据了
        List<SysUser>list=sysUserMapper.getAll();
        //基于list集合数据，创建了一个分页信息对象
        PageInfo<SysUser> pageInfo=new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public SysUser getById(int id) {
        return sysUserMapper.getById(id);
    }

    @Override
    public int insert(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public int update(SysUser sysUser) {
        return sysUserMapper.update(sysUser);
    }

    @Override
    public int delete(int id){
        return sysUserMapper.delete(id);
    }

}
