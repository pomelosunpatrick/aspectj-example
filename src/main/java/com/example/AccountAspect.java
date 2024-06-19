package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AccountAspect {
    @Pointcut("@within(com.example.UtilMethod) && execution(* com.example.Account.*(..))")
    public void callUtilMethod() {}

    @Before("callUtilMethod()")
    public void beforeCallUtilMethod(JoinPoint joinPoint) {
        System.out.println("[Before] calling " + joinPoint.getSignature());
    }

    @After("callUtilMethod()")
    public void afterCallUtilMethod(JoinPoint joinPoint) {
        System.out.println("[After] calling " + joinPoint.getSignature());
    }
}
