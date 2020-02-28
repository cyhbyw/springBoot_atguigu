package com.cyh.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "用户信息控制类")
public class UserController {

    @ApiOperation(value = "新增用户信息", httpMethod = "POST")
    @GetMapping("/time")
    public String addUser() {
        String now = LocalDateTime.now().toString();
        System.out.println(now);
        return now;
    }

}
