package com.atguigu.test;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author 姽辫
 * @className CyclicBarrierDemo
 * @Requirement 问：当线程数达到n个时买定离手！开盘！
 * @date Create in 2022-09-07 23:40
 */
/*
CyclicBarrier这个循环屏障实际上是隔离用的，隔多少个线程给来个Barrier，
isBroken就是说有没有因为异常或者超时啥的冲破Barrier
比如斗地主一桌三个人，一个大厅好多人，那就每凑三个人的线程开启一个游戏线程？我猜的
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            System.out.println("买定离手！开盘了！！");
        });
        for (int i = 0; i < 30; i++) {

            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int numberWaiting = cyclicBarrier.getNumberWaiting();//现在有多少线程在等着呀？
            System.out.println("numberWaiting : " + numberWaiting);
            int parties = cyclicBarrier.getParties();//多少个拦一次？
            System.out.println("parties : " + parties);
            boolean broken = cyclicBarrier.isBroken();//栅栏冲破了没呀？
            System.out.println("isBroken : " + broken);
        }


    }
}
