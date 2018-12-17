package com.cyh.service;

import org.springframework.stereotype.Component;

/**
 * @author: yanhua.chen
 * @date: 2018/11/7 10:07
 */
@Component
public class MathCalculateService {

    public void add(int a, int b) {
        System.err.println(String.format("The result of %d + %d is %d\n", a, b, a + b));
    }

}
