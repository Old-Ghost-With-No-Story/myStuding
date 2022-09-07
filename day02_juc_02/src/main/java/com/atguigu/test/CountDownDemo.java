package com.atguigu.test;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 姽辫
 * @Requirement 问：买票所有线程执行完，看看需要多长时间
 * @className CountDownDemo
 * @date Create in 2022-09-07 21:30
 */
class Ticket {
    public static long count = 100000L;
    private Lock lock = new ReentrantLock();

    /*public void sale() {
        lock.lock();
        try {
            if (count > 0)
                System.out.println(Thread.currentThread().getName() + "正在出票，当前剩余：" + (count) + "张...出票成功，当前剩余" + (--count) + "张");
        } finally {
            lock.unlock();
        }
    }*/
    public synchronized void sale() {
        if (count > 0)
            System.out.println(Thread.currentThread().getName() + "正在出票，当前剩余：" + (count) + "张...出票成功，当前剩余" + (--count) + "张");
    }
}

public class CountDownDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        Ticket ticket = new Ticket();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (ticket.count != 0) ticket.sale();
                countDownLatch.countDown();
            }, "编号" + i).start();
        }
        long count = countDownLatch.getCount();
        System.out.println(count);
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + " ms");


    }
}
