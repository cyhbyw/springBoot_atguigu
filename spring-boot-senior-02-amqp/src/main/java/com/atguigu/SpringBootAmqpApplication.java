package com.atguigu;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: CYH
 * @date: 2018/11/6 0006 8:14
 */
@SpringBootApplication
@EnableRabbit
public class SpringBootAmqpApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootAmqpApplication.class, args);
    }


}
