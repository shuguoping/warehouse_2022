package com.example.mybatisdemo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dataservertype implements Serializable {

    private Integer id; //服务类别编号
    private String name; //服务类别名称:1、咨询 2、投诉 3、建议

    private static final long serialVersionUID = 1L;
}