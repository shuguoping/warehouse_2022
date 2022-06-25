package com.example.mybatisdemo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dataclientlevel implements Serializable {

    private Integer id; //企业客户等级编号
    private String name; //企业客户等级名称

    private static final long serialVersionUID = 1L;
}