package com.atguigu.test;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 姽辫
 * @className CallableDemo2
 * @date Create in 2022-09-09 11:37
 */
public class CallableDemo2
{
    private volatile int number = 0;

    public int getNumber()
    {
        return number;
    }

    public synchronized void setNumber()
    {
        number++;
    }

    //==================我是美丽分割线===============================

    //多线程环境   使用    原子类AtomicInteger保证线程安全（基本数据类型）
    AtomicInteger atomicInteger = new AtomicInteger();
    public AtomicInteger getAtomicInteger()
    {
        return atomicInteger;
    }
    public void setAtomicInteger()
    {
        atomicInteger.getAndIncrement();//i++
        //java  = (C++)--
    }


    public static void main(String[] args) throws InterruptedException
    {
        CallableDemo2 casDemo = new CallableDemo2();
        CountDownLatch countDownLatch = new CountDownLatch(10000);


        for (int i = 1; i <=10000; i++) {
            new Thread(() -> {
                for (int j = 0; j <10000 ; j++) {
                    casDemo.setNumber();
                    casDemo.setAtomicInteger();
                }
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        //暂停毫秒,生产绝对不可以用，只是教学测试
        //try { TimeUnit.MILLISECONDS.sleep(400); } catch (InterruptedException e) { e.printStackTrace(); }
        countDownLatch.await();

        System.out.println(Thread.currentThread().getName()+"\t"+"结果："+casDemo.getNumber());
        System.out.println(Thread.currentThread().getName()+"\t"+"结果："+casDemo.getAtomicInteger().get());

    }

    private static void helloCAS()
    {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 6)+"\t"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 220310)+"\t"+atomicInteger.get());
    }
}
