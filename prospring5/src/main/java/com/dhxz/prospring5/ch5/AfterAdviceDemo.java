package com.dhxz.prospring5.ch5;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceDemo {
    private static KeyGenerator getKeyGenerator() {
        KeyGenerator target = new KeyGenerator();
        AfterReturningAdvice advice = new WeakKeyCheckAdvice();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(advice);
        pf.setTarget(target);
        return (KeyGenerator) pf.getProxy();
    }


    public static void main(String[] args) {
        KeyGenerator keyGen = getKeyGenerator();
        for (int i = 0; i < 10; i++) {
            try {
                long key = keyGen.getKey();
                System.out.println("Key: "+ key);
            }catch (SecurityException ex) {
                System.out.println("Weak key Generated!");
            }
        }
    }
}
