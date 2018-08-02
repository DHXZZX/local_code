package com.dhxz.lock_sample.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author 10066610
 * Mysql的并发锁实现
 */
@Component
public class MysqlLockImp implements Lock {

    @Autowired
    MysqlLockRepository repository;

    private final String LOCK_KEY = getClass().getName();

    private Random random = new Random();

    @Override
    public void lock() {
        repository.save(new MysqlLock(LOCK_KEY));
    }

    @Override
    public boolean tryLock() {
        try {
            lock();
        }catch (Exception ignore) {
            try {
                Thread.sleep(random.nextInt(20));
                tryLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void unlock() {
        repository.delete(new MysqlLock(LOCK_KEY));
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
