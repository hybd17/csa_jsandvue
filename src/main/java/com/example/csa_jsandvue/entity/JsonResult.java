package com.example.csa_jsandvue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult<E> implements Serializable {
    private Integer state;//状态码
    private String message;//描述信息
    private E data;//数据 声明为泛型

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }
    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public JsonResult(Integer state, String message, E data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }
}
