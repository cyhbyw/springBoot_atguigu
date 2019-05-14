package com.cyh.web.mvc.message.converter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cyh.web.mvc.message.converter.entity.User;

/**
 * @author: yanhua.chen
 * @date: 2019/5/14 13:38
 */
@RestController
public class UserController {


    @PostMapping("/user/add")
    public String addUser(@RequestBody User user) {
        System.err.println("添加用户，请求参数：" + user);
        return user.toString();
    }

}
