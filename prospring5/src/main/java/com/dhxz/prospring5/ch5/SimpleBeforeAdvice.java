package com.dhxz.prospring5.ch5;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

    public static void main(String[] args) {

        Guitarist johnMayer = new Guitarist();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(johnMayer);
        Guitarist proxy = (Guitarist) pf.getProxy(ClassLoader.getSystemClassLoader());

        proxy.sing();

    }
    @Override
    public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
        //System.out.println("Before '" + method.getName() + "', tune guitar.");
        System.out.println("Before method: " + method);

    }
}
