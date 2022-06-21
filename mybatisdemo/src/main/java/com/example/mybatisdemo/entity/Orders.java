package com.example.mybatisdemo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName orders
 */
@Data
public class Orders implements Serializable {
    /**
     * 订单编号
     */
    private Integer id;

    /**
     * 订购日期
     */
    private String date;

    /**
     * 送货地址
     */
    private String address;

    /**
     * 订单状态
1、未回款 2、已回款
     */
    private Integer state;

    /**
     * 
     */
    private String clientcode;

    /**
     * 订单总金额
     */
    private Integer total;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}