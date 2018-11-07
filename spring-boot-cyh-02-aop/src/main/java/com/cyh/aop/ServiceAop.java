package com.cyh.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author: yanhua.chen
 * @date: 2018/11/7 10:08
 */
@Aspect
@Component
public class ServiceAop {

    @Before(value = "execution(public * com.cyh.service..*.*(..))")
    public void beforeAdvice() {
        System.err.println("beforeAdvice()...");
    }

}
