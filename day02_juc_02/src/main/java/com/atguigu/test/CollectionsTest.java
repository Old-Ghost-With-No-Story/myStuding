package com.atguigu.test;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author 姽辫
 * @className CollectionsTest
 * @date Create in 2022-09-07 18:40
 */

public class CollectionsTest {

    public static void main(String[] args) {


        //来吧 ArrayList底层啥原理：
        /*
            首先，底层数据结构是动态数组的结构
            刚创建出来空数组的长度是0，当新添加一个元素的时候长度为默认长度10，底层使用的是一个缓冲区的方式
            如果add方法发现他容量已经满了（发现的话会先掉方法检查）调用grow方法扩容
            int newCapacity = oldCapacity + (oldCapacity >> 1); 1.5倍
            还有一个值得关注的属性，modCount，记录的是这个数组备操作的次数，
            一般多线程操作不加锁或者迭代器使用不规范会发生 并发操作发生异常
         */

        /*-------------------------线程不安全案例-------------------------------*/
        Map<Object,Object> map = new ConcurrentHashMap<>();//Collections.synchronizedMap(new HashMap<>());//new HashMap<>();
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(() -> {
                map.put(finalI,finalI);
                System.out.println(map);
            }, String.valueOf(i)).start();
        }

        /*Set<Object> set = new CopyOnWriteArraySet<>();//Collections.synchronizedSet(new HashSet<>());//new HashSet<>();
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(() -> {
                set.add(finalI);
                System.out.println(set);
            }, String.valueOf(i)).start();
        }*/

        //List<Object> list = new ArrayList<>();
        /*for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(() -> {
                list.add(finalI);
                System.out.println(list);
            }, String.valueOf(i)).start();
        }*/

        /*-------------------------解决线程不安全-------------------------------*/
        /*
        Vector 是最初级的动态数组集合类，它底层所有方法都是加了synchronize关键字的，线程绝对安全，效率绝对低下
        Collections 工具类中有一个synchronizedXxx的方法，底层会给你准备一个monitor，给这个类多线程可能影响的地方加锁
        CopyOnWriteArrayList 底层原理：
            简而言之 写时复制
            对增删改的操作都会加lock，并且在操作的时候先复制，不影响别人读，操作完之后再覆盖原数据
         */
/*        List<Object> list = new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>());//new Vector<>();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                list.add(finalI);
                System.out.println(list);
            }, String.valueOf(i)).start();
        }*/

    }
}
