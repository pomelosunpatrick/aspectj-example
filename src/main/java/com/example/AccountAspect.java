package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AccountAspect {
    // NOTE: the condition 'execution(* *(..))' is necessary otherwise the actions will be executed twice
    // 1. Once for the JointPoint where the call is made (caller)
    // 2. Once for the JointPoint where the called method is actually executed (callee)
    @Pointcut("@annotation(com.example.UtilMethod) && execution(* *(..))")
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
