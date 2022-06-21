package com.example.mybatisdemo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName clientlinkman
 */
@Data
public class Clientlinkman implements Serializable {
    /**
     * 客户联系人编号
     */
    private Integer linkmanid;

    /**
     * 客户联系人姓名
     */
    private String linkmanname;

    /**
     * 客户联系人性别
0、男 1、女
     */
    private Integer linkmansex;

    /**
     * 客户联系人职位
     */
    private String linkmanjob;

    /**
     * 客户联系人办公电话
     */
    private String linkmantel;

    /**
     * 客户联系人手机
     */
    private String linkmanmoblie;

    /**
     * 备注
     */
    private String remark;

    /**
     * 客户编号
     */
    private String code;

    private static final long serialVersionUID = 1L;
}