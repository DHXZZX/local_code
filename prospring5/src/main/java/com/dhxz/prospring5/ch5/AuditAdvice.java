package com.dhxz.prospring5.ch5;

import org.aspectj.lang.JoinPoint;

public class AuditAdvice {
    public void simpleBeforeAdvice(JoinPoint joinpoint) {
        System.out.println("Executing: "+
            joinpoint.getSignature().getDeclaringTypeName() + " "
            + joinpoint.getSignature().getName());
    }
}
