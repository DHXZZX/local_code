package com.dhxz.lock_sample.service;

import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements Runnable{

    int totalNum = 1000;

    @Override
    public void run() {
       if (totalNum > 0) {
           totalNum --;
           System.out.println("当前线程 : "  + Thread.currentThread().getName());
       }
    }
}
