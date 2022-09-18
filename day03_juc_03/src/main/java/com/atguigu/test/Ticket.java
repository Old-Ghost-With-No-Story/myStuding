package com.atguigu.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {
    public static int count = 50;
    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (count > 0)
                System.out.println(Thread.currentThread().getName() + "正在为您出票，当前剩余：" + (count) + "张...出票成功，当前剩余" + (--count) + "张");
        } finally {
            lock.unlock();
        }
    }
}