package com.dhxz.base.sync001;

public class MyThread extends Thread {
    private int count = 5;

    @Override
    public synchronized void run() {
        count --;
        System.out.println(currentThread().getName() + "count = " + count);
    }
}
