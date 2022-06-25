package com.example.mybatisdemo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientreprievelose implements Serializable {

    private Integer reprieveloseid; //客户暂缓流式记录编号
    private String reprievestep; //暂缓措施项
    private String code; //客户编号

    private static final long serialVersionUID = 1L;
}