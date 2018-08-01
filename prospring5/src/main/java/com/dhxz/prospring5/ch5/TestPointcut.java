package com.dhxz.prospring5.ch5;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.util.Objects;

public class TestPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, @Nullable Class<?> targetClass) {
        return Objects.equals(method.getName(),"advices");
    }
}
