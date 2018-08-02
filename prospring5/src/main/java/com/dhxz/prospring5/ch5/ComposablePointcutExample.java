package com.dhxz.prospring5.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.util.Objects;

public class ComposablePointcutExample {
    public static void main(String[] args) {
        GrammyGuitaristS johnMayer = new GrammyGuitaristS();
        ComposablePointcut pc = new ComposablePointcut(ClassFilter.TRUE, new SingMethodMatcher());
        System.out.println("Test 1 >>");
        GrammyGuitaristS proxy = getProxy(pc, johnMayer);
        testInvoke(proxy);

        System.out.println();
        System.out.println("Test 2 >> ");
        pc.union(new TalkMethodMatcher());
        proxy = getProxy(pc, johnMayer);
        testInvoke(proxy);
        System.out.println();
        System.out.println("Test 3 >> ");
        pc.intersection(new RestMethodMatcher());
        proxy = getProxy(pc, johnMayer);
        testInvoke(proxy);
    }

    private static GrammyGuitaristS getProxy(ComposablePointcut pc,
                                            GrammyGuitaristS target) {
        Advisor advisor = new DefaultPointcutAdvisor(pc,
                new SimpleBeforeAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        return (GrammyGuitaristS) pf.getProxy();
    }

    private static void testInvoke(GrammyGuitaristS proxy) {
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.talk();
        proxy.rest();
    }

    private static class SingMethodMatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, @Nullable Class<?> targetClass) {
            return Objects.equals("si",method.getName());
        }
    }

    private static class TalkMethodMatcher extends StaticMethodMatcher {

        @Override
        public boolean matches(Method method, @Nullable Class<?> targetClass) {
            return Objects.equals("talk",method.getName());
        }
    }

    private static class RestMethodMatcher extends StaticMethodMatcher {

        @Override
        public boolean matches(Method method, @Nullable Class<?> targetClass) {
            return Objects.equals("st",method.getName());
        }
    }
}
