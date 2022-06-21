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
    private Integer id;
    private String source;
    private String custname;
    private String title;
    private Integer rate;
    private String linkman;
    private String tel;
    private String desc;
    private Object createid;
    private String createdate;
    private Integer dueid;
    private String duedate;
    private Integer status;

    List<Saleplan> plans;

    private static final long serialVersionUID = 1L;
}