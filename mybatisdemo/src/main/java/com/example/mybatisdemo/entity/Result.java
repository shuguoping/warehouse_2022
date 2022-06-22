package com.example.mybatisdemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String code = "200";
    private String message = "";
    private T data;

    public Result(T data){
        this.data = data;
    }
}
