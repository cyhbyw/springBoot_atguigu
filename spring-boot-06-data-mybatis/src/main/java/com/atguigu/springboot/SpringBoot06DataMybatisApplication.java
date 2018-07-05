package com.atguigu.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.atguigu.springboot.mapper")
@SpringBootApplication
public class SpringBoot06DataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot06DataMybatisApplication.class, args);
    }
}

/**
 * @EnableTransactionManagement
 *
 * 基本上等同于 <tx:annotation-driven/>
 * 但是，在 SpringBoot 环境中，也可以不加此注解！！
 * 因为，SpringBoot 会自动注入 DataSourceTransactionManagerAutoConfiguration
 * 有了此类，就会注入 DataSourceTransactionManager
 *
 * 但是，如果是在非 SpringBoot 环境中，也想要使用纯注解的方式来使用事务的话，就需要加上 @EnableTransactionManagement 注解
 */
