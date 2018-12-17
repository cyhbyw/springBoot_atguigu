package com.cyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cyh.service.MathCalculateService;

/**
 * @author: yanhua.chen
 * @date: 2018/11/7 10:04
 */
@SpringBootApplication
public class SpringBootAopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootAopApplication.class, args);
        context.getBean(MathCalculateService.class).add(1, 2);
        context.close();
    }
}
