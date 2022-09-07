package com.atguigu.test1;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 姽辫
 * @className SyncLockDemo
 * @date Create in 2022-09-06 20:17
 */

public class SyncLockDemo {

    Lock lock = new ReentrantLock();

    public synchronized void m0() {
        System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t" + "----leave out");
    }

    public void m1() {
        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "----leave out");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "\t" + "没位置，走了");
        }
    }

    public void m2() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t" + "----leave out");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "\t" + "没位置，走了");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SyncLockDemo syncLockDemo = new SyncLockDemo();
        new Thread(() -> {
            syncLockDemo.m2();
        }, "A").start();
        new Thread(() -> {
            syncLockDemo.m2();
        }, "B").start();
    }
}
