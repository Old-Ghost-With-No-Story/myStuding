package com.atguigu.test;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 姽辫
 * @className BlockingQueueDemo
 * @date Create in 2022-09-08 23:53
 */

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(3);

        /*
         * offer(Obj,Time,TimeUnit)增/poll(Time,TimeUnit)查  时间内能拿到返回true，不行就返回false或者null
         */
        new Thread(() -> {
            try {
                System.out.println(queue.offer("a", 1, TimeUnit.SECONDS));
                System.out.println(queue.offer("b", 1, TimeUnit.SECONDS));
                System.out.println(queue.offer("c", 1, TimeUnit.SECONDS));
                System.out.println(queue.offer("c", 1, TimeUnit.SECONDS));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                System.out.println(queue.poll(1, TimeUnit.SECONDS));
                System.out.println(queue.poll(1, TimeUnit.SECONDS));
                System.out.println(queue.poll(1, TimeUnit.SECONDS));
                System.out.println(queue.poll(1, TimeUnit.SECONDS));
                System.out.println(queue.poll(1, TimeUnit.SECONDS));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "B").start();

        /*
        put增/take查 超了会一直阻塞直到有一个新的来了
         */
        /*new Thread(() -> {
            try {
                queue.put("f");
                queue.put("e");
                queue.put("d");
                System.out.println("1-----");
                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println("2-----");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "A").start();*/



        /*
        offer增/poll删/peek查 超了返回布尔型false或者null值，不报异常
         */
        /*new Thread(() -> {
            System.out.println(queue.offer("a"));
            System.out.println(queue.offer("B"));
            System.out.println(queue.offer("c"));
            System.out.println(queue.offer("E"));
        }, "A").start();*/

        /*
        add增/remove删/element查 超了报错！
         */
        /*new Thread(() -> {
            queue.add("a");
            queue.add("a");
            queue.add("a");
            System.out.println("1-------");
            queue.add("a");
            System.out.println("2-------");
        }, "A").start();*/

    }
}
