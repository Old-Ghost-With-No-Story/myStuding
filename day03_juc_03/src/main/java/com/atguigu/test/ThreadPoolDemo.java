package com.atguigu.test;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 姽辫
 * @className ThreadPoolDemo
 * @date Create in 2022-09-08 16:58
 */

public class ThreadPoolDemo {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < Ticket.count; i++) {
            executorService.execute(() -> {
                ticket.sale();
            });
        }

    }
}



