package com.example.mybatisdemo.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class Clientserver implements Serializable {
    private Integer id;
    private Integer typeid;
    private String title;
    private String clientcode;
    private Integer status;
    private String content;
    private Integer createid;
    private String createdate;
    private Integer dueid;
    private String duedate;
    private String processing;
    private String processingdate;
    private String processingresult;
    private Integer clientcontentment;

    private static final long serialVersionUID = 1L;
}