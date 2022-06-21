package com.example.mybatisdemo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName dataarea
 */
@Data
public class Dataarea implements Serializable {
    /**
     * 地区编号
     */
    private Integer daid;

    /**
     * 地区名称
     */
    private String daname;

    private static final long serialVersionUID = 1L;
}