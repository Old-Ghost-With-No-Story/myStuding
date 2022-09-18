package com.atguigu.test;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author 姽辫
 * @className CallableDemo
 * @date Create in 2022-09-08 20:12
 */
/*
Q：获得多线程的方式有什么
A：Thread类，Runnable接口，Callable接口

Q：Callable和Runnable 区别？
A：Runnable：无返回值，不抛出异常，运行run方法
   Callable：有返回值，抛出异常，运行call方法

Q：来吧，那你写一个吧
常规来看，好像不太行，没法直接往里加Callable的子类，怎么办呢？适配器模式搞定
来个适配器：FutureTask
 */
//需求：三个线程，A线程干3秒，B线程干4秒，C线程干6秒，得到的值累加
class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        return null;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        FutureTask<String> taskA = new FutureTask(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "，";
        });
        FutureTask<String> taskB = new FutureTask(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });
        FutureTask<String> taskC = new FutureTask(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Juc";
        });
        new Thread(taskA, "A").start();
        new Thread(taskB, "B").start();
        new Thread(taskC, "C").start();
        while (!(taskA.isDone() && taskB.isDone() && taskC.isDone())) {

        }
        try {
            System.out.println(taskB.get() + taskA.get() + taskC.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "线程耗时：" + (end - start));

    }
}
