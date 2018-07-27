package com.dhxz.prospring5.ch5;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;

public class AgentAOPDemo {
    public static void main(String[] args) {
        Agent agent = new Agent();

        ProxyFactory pf = new ProxyFactory();
        Advice advice = new AgentDecorator();
        pf.addAdvice(advice);
        pf.setTarget(agent);
        Agent proxy = (Agent) pf.getProxy();
        agent.speak();
        System.out.println("------------------");
        proxy.speak();

        System.out.println(pf.adviceIncluded(advice));
        System.out.println(pf.countAdvicesOfType(AgentDecorator.class));
    }
}
