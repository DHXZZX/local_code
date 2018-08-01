package com.dhxz.prospring5.ch5;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ControlFlowDemo {
    public static void main(String[] args) {
        ControlFlowDemo ex = new ControlFlowDemo();
        ex.run();
    }

    public void run() {
        TestBean target = new TestBean();
        ControlFlowPointcut pc = new ControlFlowPointcut(ControlFlowDemo.class, "test");
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);

        TestBean proxy = (TestBean) pf.getProxy();
        System.out.println("\tTrying normal invoke");
        proxy.foo();
        System.out.println("\n\tTrying under ControlFlowDemo.test()");
        test(proxy);
    }

    private void test(TestBean bean) {
        bean.foo();
    }
}
