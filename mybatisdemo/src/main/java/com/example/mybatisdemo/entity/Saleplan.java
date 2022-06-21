package com.example.mybatisdemo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Saleplan implements Serializable {
    private Integer id;
    private Integer chcid;
    private String todo;
    private String result;

    private Salechance salechance;

    private static final long serialVersionUID = 1L;

}