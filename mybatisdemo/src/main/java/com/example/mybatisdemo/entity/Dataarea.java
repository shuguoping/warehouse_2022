package com.example.mybatisdemo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dataarea implements Serializable {

    private Integer daid; //地区编号
    private String daname; //地区名称

    private static final long serialVersionUID = 1L;
}