package com.dhxz.prospring5.ch5;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectjexpPointcutDemo {
    public static void main(String[] args) {
        NewGuitarist johnMayer = new NewGuitarist();
        AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
        pc.setExpression("execution(* sing*(..))");
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(johnMayer);
        pf.addAdvisor(advisor);
        NewGuitarist proxy = (NewGuitarist) pf.getProxy();

        proxy.sing();
        proxy.sing2();
        proxy.rest();
    }
}
