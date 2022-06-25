package com.example.mybatisdemo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientinfo implements Serializable {

    private String code; //客户编号（KH + 六位日期数字 + 三位数字流水号）
    private String name; //客户名称
    private Integer areaid; //客户所在地区：1、北京  2、华北  3、中南  4、东北  5、西部
    private Integer custid; //所属客户经理编号
    private Integer levelid; //客户等级:1、普通客户 2、大客户 3、合作伙伴 4、战略合作伙伴
    private Integer contentment; //客户满意度:1、☆ 2、☆☆ 3、☆☆☆ 4、☆☆☆☆ 5、☆☆☆☆☆
    private Object credit; //客户信用度:1、☆ 2、☆☆ 3、☆☆☆ 4、☆☆☆☆ 5、☆☆☆☆☆
    private String address; //客户地址
    private String dakcode; //客户邮政编码
    private String tel; //电话
    private String fax; //传真
    private String net; //网址
    private String charter; //营业执照注册号
    private String corporation; //法人
    private Integer bankroll; //注册资金（万元）
    private Integer turnoveryear; //年营业额（万元）
    private String bank; //开户银行
    private String accounts; //银行账号
    private String nativetax; //地税登记号
    private String countrytax; //国税登记号
    private Integer state; //客户状态:1、正常 2、暂缓流失 3、已流失 注意：只有在暂缓流失状态下，才可以转化为确认流失状态。
    private String losereason; //客户流失原因
    private String losedate; //客户流失日期

    private static final long serialVersionUID = 1L;
}