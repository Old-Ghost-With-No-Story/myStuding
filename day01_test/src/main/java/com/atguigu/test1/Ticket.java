package com.atguigu.test1;


/**
 * @author 姽辫
 * @className Ticket
 * @date Create in 2022-09-06 14:25
 */

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 买票卖票demo
 */
public class Ticket {
    public static long count = 100L;
    private Lock lock = new ReentrantLock(true);

    public void sale() {
        lock.lock();
        try {
            if (count > 0)
                System.out.println(Thread.currentThread().getName() + "正在出票，当前剩余：" + (count) + "张...出票成功，当前剩余" + (--count) + "张");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

    }
    /*public synchronized void sale() {
        if (count > 0)
            System.out.println(Thread.currentThread().getName() + "正在出票，当前剩余：" + (count) + "张...出票成功，当前剩余" + (--count) + "张");
    }*/
}


class TicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {for (long i = 0; i <= 100L; i++) ticket.sale();}, "A").start();
        new Thread(() -> {for (long i = 0; i <= 100L; i++) ticket.sale();}, "B").start();
        new Thread(() -> {for (long i = 0; i <= 100L; i++) ticket.sale();}, "C").start();
    }
}
