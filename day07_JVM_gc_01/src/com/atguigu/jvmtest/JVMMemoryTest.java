package com.atguigu.jvmtest;


import java.util.concurrent.TimeUnit;

/**
 * @author 姽辫
 * @className Test01
 * @date Create in 2022-09-16 20:27
 */

public class JVMMemoryTest {
    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory() ;//返回Java虚拟机中的内存总量。
        long maxMemory = Runtime.getRuntime().maxMemory() ;//返回Java虚拟机将尝试使用的最大内存量。
        long freeMemory = Runtime.getRuntime().freeMemory() ;//返回Java虚拟机中的可用内存量。
        System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory + "（字节）、" + (totalMemory / (double)1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + maxMemory + "（字节）、" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("freeMemory = " + freeMemory + "（字节）、" + (freeMemory / (double)1024 / 1024) + "MB");

        System.out.println();
        System.out.println("===========111====================");
        byte[] bytes01 = new byte[60 * 1024 * 1024];
        System.out.println("TOTAL_MEMORY(-Xms) = " + Runtime.getRuntime().totalMemory() + "（字节）、" + (Runtime.getRuntime().totalMemory() / (double)1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + Runtime.getRuntime().maxMemory() + "（字节）、" + (Runtime.getRuntime().maxMemory() / (double)1024 / 1024) + "MB");
        System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory() + "（字节）、" + (Runtime.getRuntime().freeMemory() / (double)1024 / 1024) + "MB");

        System.out.println();
        System.out.println("===========222====================");
        byte[] bytes02 = new byte[30 * 1024 * 1024];
        System.out.println("TOTAL_MEMORY(-Xms) = " + Runtime.getRuntime().totalMemory() + "（字节）、" + (Runtime.getRuntime().totalMemory() / (double)1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + Runtime.getRuntime().maxMemory() + "（字节）、" + (Runtime.getRuntime().maxMemory() / (double)1024 / 1024) + "MB");
        System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory() + "（字节）、" + (Runtime.getRuntime().freeMemory() / (double)1024 / 1024) + "MB");

        System.out.println();
        System.out.println("===========444====================");
        byte[] bytes03 = new byte[30 * 1024 * 1024];
        System.out.println("TOTAL_MEMORY(-Xms) = " + Runtime.getRuntime().totalMemory() + "（字节）、" + (Runtime.getRuntime().totalMemory() / (double)1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + Runtime.getRuntime().maxMemory() + "（字节）、" + (Runtime.getRuntime().maxMemory() / (double)1024 / 1024) + "MB");
        System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory() + "（字节）、" + (Runtime.getRuntime().freeMemory() / (double)1024 / 1024) + "MB");

        System.gc();
        //暂停毫秒
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("################################");
        System.out.println("TOTAL_MEMORY(-Xms) = " + Runtime.getRuntime().totalMemory() + "（字节）、" + (Runtime.getRuntime().totalMemory() / (double)1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + Runtime.getRuntime().maxMemory() + "（字节）、" + (Runtime.getRuntime().maxMemory() / (double)1024 / 1024) + "MB");
        System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory() + "（字节）、" + (Runtime.getRuntime().freeMemory() / (double)1024 / 1024) + "MB");
/**/
    }
}
