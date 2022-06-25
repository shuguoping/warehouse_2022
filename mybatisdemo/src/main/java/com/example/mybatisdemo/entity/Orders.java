package com.example.mybatisdemo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {

    private Integer id; //订单编号
    private String date; //订购日期
    private String address; //送货地址
    private Integer state; //订单状态:1、未回款 2、已回款
    private String clientcode; //客户编号
    private Integer total; //订单总金额
    private String remark; //备注

    private static final long serialVersionUID = 1L;
}