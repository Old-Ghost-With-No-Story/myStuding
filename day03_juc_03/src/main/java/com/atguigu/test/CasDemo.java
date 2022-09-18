package com.atguigu.test;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 姽辫
 * @className CasDemo
 * @date Create in 2022-09-08 18:49
 */
/*
Q：不加锁，能不能保证一个变量的原子性？
A：当然可以！用CAS全称Compare And Swap算法
   之前加锁本质上是一种悲观锁（觉得人家一定会修改，那我还是每次操作都上锁吧）
   CAS呢不是这样，他是一种乐观锁的形式，我去操作数据比如我拿来一个数据要修改，
   修改完了，回去一看数据没变，那就把之前的数据覆盖成我新修改的数据，
   修改完了，回去一看数据变了！那就再拿一次再去修改，就很乐观

Q：CAS底层原理？
A：要有一个之前拿到的旧值，和你更新完之后的值
   C和S的对象是缓存中的那个数据，首先就要确定缓存数据中的坐标valueOffset，
   根据这个坐标找到当前的缓存中的值，和旧的值比较一下
   如果一样，替换成你更新完之后的值
   如果不一样，再把现在的Copy走，再去改，如此循环，这个循环就是所谓自旋

Q：这样有什么好处有什么不好的
A：好处显而易见，效率更高，所有线程都充分调用起来
   不好的地方也显而易见，线程长时间处于自旋的状态，CPU负担很大
   只能保证一个共享变量
   还有就是加入一个线程操作完成之后，回去看到的发现诶还是和之前一样的值，但是这个值有可能已经被多次改过，
   只不过最终结果是没问题的，这样也会导致线程不安全的状况，解决这个问题可以引入一个版本号，
   每修改一次就更新版本号，集合中的modCount本质也是乐观锁的版本号


 */
public class CasDemo {
    public static void main(String[] args) {
        NewTicket ticket = new NewTicket();
        new Thread(() -> {
            for (long i = 0; i <= NewTicket.capacity + 1; i++) ticket.sale();
        }, "A").start();
        new Thread(() -> {
            for (long i = 0; i <= NewTicket.capacity + 1; i++) ticket.sale();
        }, "B").start();
        new Thread(() -> {
            for (long i = 0; i <= NewTicket.capacity + 1; i++) ticket.sale();
        }, "C").start();
    }
   /*public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(10);
        System.out.println(i.get());
        boolean b = i.compareAndSet(10, 100);
        System.out.println(b);
        System.out.println(i.get());
    }*/


}

/**
 * 需求：改造卖票
 */
class NewTicket {
    public static final int capacity = 300000;
    public static AtomicInteger count = new AtomicInteger(capacity);
    private Lock lock = new ReentrantLock(true);

 /*   public void sale() {
        lock.lock();
        try {
            if (count.get() > 0)
                System.out.println(Thread.currentThread().getName() + "正在出票，当前剩余：" + (count.get()) + "张...出票成功，当前剩余" + (count.decrementAndGet()) + "张");
        } finally {
            lock.unlock();
        }
    }*/

    public void sale() {
        if (count.get() > 0)
            System.out.println(Thread.currentThread().getName() + "正在出票，当前剩余：" + (count.get()) + "张...出票成功，当前剩余" + (count.decrementAndGet()) + "张");
    }
}



