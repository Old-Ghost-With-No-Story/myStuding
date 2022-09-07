package com.atguigu.test;


import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 姽辫
 * @className Semaphore
 * @date Create in 2022-09-08 0:16
 */
/*
Semaphore类api
构造方法：
Semaphore(int permits) ：创建具有给定的许可数和非公平的公平设置的 Semaphore。
Semaphore(int permits, boolean fair)：创建具有给定的许可数和给定的公平设置的 Semaphore。
方法：
acquire() ：从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断。
acquire(int permits) ：从此信号量获取给定数目的许可，在提供这些许可前一直将线程阻塞，或者线程已被中断。
release() ：  释放一个许可，将其返回给信号量。
release(int permits) ：释放给定数目的许可，将其返回到信号量。
availablePermits() ：返回此信号量中当前可用的许可数。返回值int
drainPermits() ：获取并返回立即可用的所有许可。返回值int
getQueuedThreads() ：返回正在等着的线程集合，返回值 Collection<Thread>
getQueueLength() ：返回正在等的线程的数量
hasQueuedThreads() ： 看是不是有线程在等
isFair() ：公不公平？
 */

//假设需求：一个程序很垃圾，只能容纳10个线程，否则就崩了，现在突然来了100个线程，快救救它！
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "来了！");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(2) + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "走了！");
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }


    }

}
