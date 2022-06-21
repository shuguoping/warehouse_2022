package com.example.mybatisdemo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName dataservertype
 */
@Data
public class Dataservertype implements Serializable {
    /**
     * 服务类别编号
     */
    private Integer id;

    /**
     * 服务类别名称
1、咨询
2、投诉
3、建议
     */
    private String name;

    private static final long serialVersionUID = 1L;
}