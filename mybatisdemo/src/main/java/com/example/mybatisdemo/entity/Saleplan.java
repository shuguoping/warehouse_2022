package com.example.mybatisdemo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Saleplan implements Serializable {
    private Integer id; //销售机会执行计划编号
    private Integer chcid; //所属销售机会编号
    private String todo; //执行内容
    private String result; //执行结果

    private Salechance salechance;

    private static final long serialVersionUID = 1L;

}