package com.example.mybatisdemo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName dataclientlevel
 */
@Data
public class Dataclientlevel implements Serializable {
    /**
     * 企业客户等级编号
     */
    private Integer id;

    /**
     * 企业客户等级名称
     */
    private String name;

    private static final long serialVersionUID = 1L;
}