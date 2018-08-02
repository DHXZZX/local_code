package com.dhxz.prospring5.ch5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AppNamespaceDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-xml.xml");
        ctx.refresh();
        NewDocumentarist documentarist =
                ctx.getBean("documentarist", NewDocumentarist.class);
        documentarist.execute();
        ctx.close();
    }
}
