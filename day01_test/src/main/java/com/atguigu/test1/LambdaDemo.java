package com.atguigu.test1;


import com.sun.org.apache.bcel.internal.generic.RET;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;

/**
 * @author 姽辫
 * @className LambdaDemo
 * @date Create in 2022-09-06 21:02
 */
@FunctionalInterface
interface Foo {
    /*public int m1(int y);*/
    public abstract int m1(int x, int y);
    public static void add(){
        synchronized (""){

        }
        System.out.println("1");
    }

}

public class LambdaDemo {
    public static void main(String[] args) {
        Foo foo = (x, y) -> x + y;
        System.out.println(foo.m1(5, 5));
        System.out.println(foo);
        int maxValue = Integer.MAX_VALUE;
        System.out.println();

/*        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println();
            }
        });
        new Thread(() -> System.out.println());
        Runnable target = () -> {
            System.out.println();
        };
        new Thread(target);

    }*/

    }
}
