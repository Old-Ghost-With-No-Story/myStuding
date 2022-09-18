package com.atguigu.jvmtest;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 姽辫
 * @className DeadLockTest
 * @date Create in 2022-09-16 20:30
 */

public class DeadLockTest {
    /*static Object lockA = new Object();
    static Object lockB = new Object();*/
    static Lock lockA = new ReentrantLock();
    static Lock lockB = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            lockA.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t线程得到锁A");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockB.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "\t线程试图抢夺锁B");
                } finally {
                    lockB.unlock();
                }
            } finally {
                lockA.unlock();
            }
        }, "A").start();
        new Thread(() -> {
            lockB.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t线程得到锁B");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockA.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "\t线程试图抢夺锁A");
                } finally {
                    lockA.unlock();
                }
            } finally {
                lockB.unlock();
            }
        }, "B").start();
    }
}
