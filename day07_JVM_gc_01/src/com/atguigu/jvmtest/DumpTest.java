package com.atguigu.jvmtest;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author 姽辫
 * @className Test01
 * @date Create in 2022-09-16 20:27
 */

public class DumpTest {
    public static void main(String[] args) {
        List<Cat> list = new ArrayList<>();
        while (true) {
            list.add(new Cat());
        }
    }
}

class Cat {
    byte[] catWeight = new byte[1 * 1024 * 1024];
}
