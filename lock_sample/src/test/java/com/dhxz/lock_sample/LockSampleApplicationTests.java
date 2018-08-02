package com.dhxz.lock_sample;

import com.dhxz.lock_sample.entities.CustomerRepository;
import com.dhxz.lock_sample.lock.MysqlLockImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LockSampleApplicationTests {

    @Autowired
    CustomerRepository repository;

    @Autowired
    MysqlLockImp lockImp;


    @Autowired
    MyThread myThread;

    @Test
    public void concurrentTest() {

        Thread t1 = new Thread(myThread, "t1");
        Thread t2 = new Thread(myThread, "t2");
        Thread t3 = new Thread(myThread, "t3");
        Thread t4 = new Thread(myThread, "t4");
        Thread t5 = new Thread(myThread, "t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    @Component
    class MyThread extends Thread{

        @Autowired
        MysqlLockImp lock;
        private int count = 100;
        @Override
        public void run() {
            if (lock.tryLock()) {
                try {
                    count --;
                    System.out.println(currentThread().getName() + " count = " + count);
                }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

}
