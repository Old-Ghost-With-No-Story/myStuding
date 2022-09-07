package com.atguigu.test;


/**
 * @author 姽辫
 * @className ThreeThreadsDemo
 * @date Create in 2022-09-07 21:08
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 场景：
 * A先上鱼香肉丝，B再上锅包肉，C最后上毛血旺
 */

class DongBeiRestaurant {

    private int flag = 1;//一个标记，1代表该做鱼香肉丝了，2：该做锅包肉了，3：该做毛血旺了
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void makeYuxiangrousi_1() {
        lock.lock();
        try {
            while (flag != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "做鱼香肉丝：" + flag);
            flag = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void makeGuobaorou_2() {
        lock.lock();
        try {
            while (flag != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "做锅包肉：" + flag);
            flag = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void makeMaoxuewang_3() {
        lock.lock();
        try {
            while (flag != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "做毛血旺：" + flag);
            flag = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ThreeThreadsDemo {
    public static void main(String[] args) {
        DongBeiRestaurant restaurant = new DongBeiRestaurant();
        new Thread(() -> {
            restaurant.makeYuxiangrousi_1();
        }, "我爸").start();
        new Thread(() -> {
            restaurant.makeGuobaorou_2();
        }, "我妈").start();
        new Thread(() -> {
            restaurant.makeMaoxuewang_3();
        }, "我").start();
    }
}
