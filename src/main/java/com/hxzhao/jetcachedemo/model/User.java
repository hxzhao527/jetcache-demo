package com.hxzhao.jetcachedemo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private Date createTime;
}
