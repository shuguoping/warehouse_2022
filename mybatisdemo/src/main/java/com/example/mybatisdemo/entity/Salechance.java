package com.example.mybatisdemo.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salechance implements Serializable {
    private Integer id; //销售机会编号
    private String source; //机会来源
    private String custname; //客户名称
    private String title; //概要
    private Integer rate; //成功机率(从0到100的数字)
    private String linkman; //联系人
    private String tel; //联系人电话
    private String desc; //机会描述
    private Object createid; //创建人编号
    private String createdate; //创建日期
    private Integer dueid; //指派人编号
    private String duedate; //指派日期
    private Integer status; //销售机会状态 0:未分配 1:开发中 2:开发成功 3:开发失败

    List<Saleplan> plans;

    private static final long serialVersionUID = 1L;
}