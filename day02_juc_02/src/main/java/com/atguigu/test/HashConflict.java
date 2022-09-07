package com.atguigu.test;


import java.util.HashSet;
import java.util.Set;

/**
 * @author 姽辫
 * @className HashConflict
 * @date Create in 2022-09-07 19:03
 */

public class HashConflict {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 1100000000; i++) {
            Object o = new Object();
            o.hashCode();
            if (set.contains(o.hashCode())) {
                System.out.println("第" + (i + 1) + "个重复：" + o.hashCode());
                continue;
            }
            set.add(o.hashCode());
        }
        System.out.println(set.size());
    }
}
