package com.dhxz.prospring5.ch5;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

import static com.dhxz.prospring5.ch5.KeyGenerator.WEAK_KEY;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target) throws Throwable {

        if (target instanceof KeyGenerator && "getKey".equals(method.getName())) {
            Long key = (Long) returnValue;
            if (key == WEAK_KEY) {
                throw new SecurityException(
                        "Key Generator generated a weak key. Try again");
            }
        }
    }
}
