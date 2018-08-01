package com.dhxz.prospring5.ch5;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleThrowsAdvice implements ThrowsAdvice {
    public static void main(String[] args) {
        ErrorBean eb = new ErrorBean();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(eb);
        pf.addAdvice(new SimpleThrowsAdvice());
        ErrorBean proxy = (ErrorBean) pf.getProxy();
        try {
            proxy.errorProneMehtod();
        } catch (Exception e) {
        }
        try {
            proxy.otherErrorProneMehtod();
        }catch (Exception ignored){}
    }

    public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("********");
        System.out.println("Generic Exception Capture");
        System.out.println("Caught:" + ex.getClass().getName());
        System.out.println("********\n");
    }

    public void afterThrowing(Method method, Object args, Object target,
                              IllegalArgumentException ex) throws Throwable {
        System.out.println("***");
        System.out.println("IllegalArgumentException Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("Method: " + method.getName());
        System.out.println("***\n");
    }
}
