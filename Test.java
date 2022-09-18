import java.util.concurrent.TimeUnit;

/**
 * @author 姽辫
 * @className Test
 * @date Create in 2022-09-16 9:05
 */

public class Test {
    public static void main(String[] args) {
        new Object();
        System.gc();
        Thread a = new Thread(() -> {
            synchronized ("") {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized ("1") {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "A");

        Thread b = new Thread(() -> {
            synchronized ("1") {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized ("") {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "B");
        a.start();
        b.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
