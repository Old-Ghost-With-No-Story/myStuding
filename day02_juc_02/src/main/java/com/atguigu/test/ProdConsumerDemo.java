package com.atguigu.test;


/**
 * @author 姽辫
 * @className ProdConsumerDemo
 * @date Create in 2022-09-07 20:35
 */


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者模型：
 * 饭店里头，厨师生产一个，服务员拿走一个，前台只有一个容量
 */

class Restaurant {
    private final int DEFAULT_CAPACITY = 1;//前台默认容量容下一份菜
    private int num = 0;//前台默认开始有0份菜
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //厨师做菜
    public void increase() throws InterruptedException {
        lock.lock();
        try {
            while (num >= DEFAULT_CAPACITY) {
                //this.wait();
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "做菜，现在有：" + (++num));
            condition.signalAll();
            //this.notifyAll();
        }finally {
            lock.unlock();
        }

    }

    //服务员走菜
    public void decrease() throws InterruptedException {
        lock.lock();
        try {
            while (num < DEFAULT_CAPACITY) {
                //this.wait();
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "走菜，现在有：" + (--num));
            //this.notifyAll();
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

}

public class ProdConsumerDemo {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    restaurant.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "厨师A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    restaurant.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "服务B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    restaurant.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "厨师C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    restaurant.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "服务D").start();



    }
}
