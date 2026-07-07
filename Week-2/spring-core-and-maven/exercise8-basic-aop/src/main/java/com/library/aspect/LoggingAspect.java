package com.library.aspect;

import org.aspectj.lang.JoinPoint;

// plain advice class, wired through <aop:config> in XML (no @Aspect annotation)
public class LoggingAspect {

    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before: " + joinPoint.getSignature().getName());
    }

    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After: " + joinPoint.getSignature().getName());
    }
}
