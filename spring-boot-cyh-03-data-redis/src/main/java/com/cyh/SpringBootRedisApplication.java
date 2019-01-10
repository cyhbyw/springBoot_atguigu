package com.cyh;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author: yanhua.chen
 * @date: 2019/1/10 10:45
 */
@SpringBootApplication
public class SpringBootRedisApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisApplication.class, args);
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void run(String... args) {
        String key = "redis.sentinel.test";
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if (!stringRedisTemplate.hasKey(key)) {
            ops.set(key, "redis.sentinel.test at: " + LocalDateTime.now());
        }
        System.err.println("Got value: " + ops.get(key));
    }
}
