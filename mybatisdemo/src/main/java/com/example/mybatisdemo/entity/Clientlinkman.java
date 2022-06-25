package com.example.mybatisdemo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientlinkman implements Serializable {

    private Integer linkmanid; //客户联系人编号
    private String linkmanname; //客户联系人姓名
    private Integer linkmansex; //客户联系人性别:0、男 1、女
    private String linkmanjob; //客户联系人职位
    private String linkmantel; //客户联系人办公电话
    private String linkmanmoblie; //客户联系人手机
    private String remark; //备注
    private String code; //客户编号

    private static final long serialVersionUID = 1L;
}