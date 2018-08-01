package com.dhxz.prospring5.ch5;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class NamePointcutUsingAdvisor {
    public static void main(String[] args) {
        GrammyGuitarist johnMayer = new GrammyGuitarist();
        NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
        pc.addMethodName("sing");
        pc.addMethodName("rest");

        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(johnMayer);

        GrammyGuitarist proxy = (GrammyGuitarist) pf.getProxy();
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }
}
