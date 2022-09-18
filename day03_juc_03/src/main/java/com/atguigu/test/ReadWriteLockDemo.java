package com.atguigu.test;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 姽辫
 * @className ReadWriteLockDemo
 * @date Create in 2022-09-08 21:04
 */
/*
读写锁为何诞生？
不加锁线程不安全，加了锁写读 读写 写写操作是不影响了，但是大家都想读，那你总不能不让数据共享给大家一起读吧
这样不科学
读写锁来了

 */
/*
 * 需求：
 * 10个线程写入缓存，每个线程写1次，
 * 10个线程读取缓存，每个线程读1次，
 * 操作同一个资源来10轮
 */
class MyCache {
    private Map<Integer, Integer> map = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

 /*   public int get(int k) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\tgetter come in");
            Integer s = map.get(k);
            System.out.println(Thread.currentThread().getName() + "\tgetter come out");
            return s;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void set(int k, int v) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\tsetter come in");
            map.put(k, v);
            System.out.println(Thread.currentThread().getName() + "\tsetter come out");
        } finally {
            lock.writeLock().unlock();
        }
    }*/
    public int get(int k) {
        System.out.println(Thread.currentThread().getName() + "\tgetter come in");
        Integer s = map.get(k);
        System.out.println(Thread.currentThread().getName() + "\tgetter come out");
        return s;
    }

    public synchronized void set(int k, int v) {
        System.out.println(Thread.currentThread().getName() + "\t写 come in");
        map.put(k, v);
        System.out.println(Thread.currentThread().getName() + "\t写 come out");
    }
}

public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache cache = new MyCache();
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            int finalI1 = i;
            new Thread(() -> {
                cache.set(finalI, finalI1);
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                cache.get(finalI);
            }, String.valueOf(i)).start();
        }
    }
}
