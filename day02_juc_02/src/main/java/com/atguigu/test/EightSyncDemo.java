package com.atguigu.test;


import java.util.concurrent.TimeUnit;

/**
 * @author 姽辫
 * @className EightSyncDemo
 * @date Create in 2022-09-07 18:56
 */

class Phone {

    public  synchronized void sendEmail() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------Email");
    }

    public  synchronized void sendSMS() {
        System.out.println("---------SMS");
    }


    public void hello() {
        System.out.println("---------hello");
    }

}

public class EightSyncDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            phone.sendEmail();
        }, "A").start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            //phone.sendSMS();
            phone.hello();
            //phone2.sendSMS();
        }, "B").start();

    }
}
