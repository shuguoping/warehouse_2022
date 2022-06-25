package com.example.mybatisdemo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientserver implements Serializable {

    private Integer id; //服务编号
    private Integer typeid; //服务类型编号
    private String title; //概要
    private String clientcode; //客户编号
    private Integer status; //服务状态 1、未分配 2、已分配 3、已处理 4、已反馈
    private String content; //服务请求的内容
    private Integer createid; //创建人编号
    private String createdate; //创建日期
    private Integer dueid; //指派人编号
    private String duedate; //指派日期
    private String processing; //服务处理内容
    private String processingdate; //处理日期
    private String processingresult; //处理结果
    private Integer clientcontentment; //处理结果满意度: 1、☆ 2、☆☆ 3、☆☆☆ 4、☆☆☆☆ 5、☆☆☆☆☆

    private static final long serialVersionUID = 1L;
}