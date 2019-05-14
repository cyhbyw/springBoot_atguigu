package com.cyh.web.mvc.message.converter.entity;

import java.util.Date;

import lombok.Data;

/**
 * @author: yanhua.chen
 * @date: 2019/5/14 13:40
 */
@Data
public class User {

    private String name;

    /**
     * 如果前端通过String的方式传入并通过框架进行解析成Date的话，String的格式就很重要
     */
    private Date birthday;

}
