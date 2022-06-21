package com.example.mybatisdemo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName clientreprievelose
 */
@Data
public class Clientreprievelose implements Serializable {
    /**
     * 客户暂缓流式记录编号
     */
    private Integer reprieveloseid;

    /**
     * 暂缓措施项
     */
    private String reprievestep;

    /**
     * 客户编号
     */
    private String code;

    private static final long serialVersionUID = 1L;
}