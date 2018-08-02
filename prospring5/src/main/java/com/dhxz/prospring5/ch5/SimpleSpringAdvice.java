package com.dhxz.prospring5.ch5;

import org.aspectj.lang.JoinPoint;

public class SimpleSpringAdvice {
    public void simpleBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("Executing: " +
                joinPoint.getSignature().getDeclaringTypeName() + " "
                + joinPoint.getSignature().getName());
    }
}
