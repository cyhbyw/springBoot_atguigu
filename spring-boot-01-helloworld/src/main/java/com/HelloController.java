package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 位于 @SpringBootApplication 所在类的外面，不能被自动配置！！
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello2")
    public String hello(){
        return "Hello World!";
    }
}
