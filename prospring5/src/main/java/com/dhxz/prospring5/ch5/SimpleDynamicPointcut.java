package com.dhxz.prospring5.ch5;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.util.Objects;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, @Nullable Class<?> targetClass) {
        System.out.println("Static check for " + method.getName());
        return Objects.equals("foo",method.getName());
    }

    @Override
    public boolean matches(Method method, @Nullable Class<?> targetClass, Object... args) {
        System.out.println("Dynamic check for " + method.getName());
        int x = (Integer) args[0];
        return x != 100;
    }

    @Override
    public ClassFilter getClassFilter() {
        return cls->cls == SampleBean.class;
    }
}
