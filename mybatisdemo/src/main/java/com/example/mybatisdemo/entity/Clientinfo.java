package com.example.mybatisdemo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName clientinfo
 */
@Data
public class Clientinfo implements Serializable {
    /**
     * 客户编号（KH + 六位日期数字 + 三位数字流水号）
     */
    private String code;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 客户所在地区：
1、北京  2、华北  3、中南  4、东北  5、西部
     */
    private Integer areaid;

    /**
     * 所属客户经理编号
     */
    private Integer custid;

    /**
     * 客户等级
1、普通客户 2、大客户 3、合作伙伴 4、战略合作伙伴
     */
    private Integer levelid;

    /**
     * 客户满意度
1、☆ 2、☆☆ 3、☆☆☆ 4、☆☆☆☆ 5、☆☆☆☆☆
     */
    private Integer contentment;

    /**
     * 客户信用度
1、☆ 2、☆☆ 3、☆☆☆ 4、☆☆☆☆ 5、☆☆☆☆☆
     */
    private Object credit;

    /**
     * 客户地址
     */
    private String address;

    /**
     * 客户邮政编码
     */
    private String dakcode;

    /**
     * 电话
     */
    private String tel;

    /**
     * 传真
     */
    private String fax;

    /**
     * 网址
     */
    private String net;

    /**
     * 营业执照注册号
     */
    private String charter;

    /**
     * 法人
     */
    private String corporation;

    /**
     * 注册资金（万元）
     */
    private Integer bankroll;

    /**
     * 年营业额（万元）
     */
    private Integer turnoveryear;

    /**
     * 开户银行
     */
    private String bank;

    /**
     * 银行账号
     */
    private String accounts;

    /**
     * 地税登记号
     */
    private String nativetax;

    /**
     * 国税登记号
     */
    private String countrytax;

    /**
     * 客户状态
1、正常 2、暂缓流失 3、已流失
注意：只有在暂缓流失状态下，才可以转化为确认流失状态。
     */
    private Integer state;

    /**
     * 客户流失原因
     */
    private String losereason;

    /**
     * 客户流失日期
     */
    private String losedate;

    private static final long serialVersionUID = 1L;
}