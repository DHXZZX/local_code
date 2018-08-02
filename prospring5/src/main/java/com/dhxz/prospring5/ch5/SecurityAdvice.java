package com.dhxz.prospring5.ch5;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.util.Optional;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }
    @Override
    public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
        Optional<UserInfo> userOpt = securityManager.getLoggedOnUser();
        if (!userOpt.isPresent()) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login before attempting to invoke the method:" +
                    method.getName());
        }else if ("John".equals(userOpt.get().userName())) {
            System.out.println("Logged in user is John - OKAY!");
        }else {
            System.out.println("Logged in user is " + userOpt.get().userName()
                    + " NOT GOOD :(");
            throw new SecurityException("User " + userOpt.get().userName()
                    + " is not allowed access to method " + method.getName());
        }
    }
}
