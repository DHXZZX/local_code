package com.dhxz.prospring5.ch5;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AnnotationPointcutDemo {
    public static void main(String[] args) {
        Guitarist2 johnMayer = new Guitarist2();
        AnnotationMatchingPointcut pc = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(johnMayer);

        Guitarist2 proxy = (Guitarist2) pf.getProxy();
        proxy.sing(new Guitar());
        proxy.rest();
    }
}
