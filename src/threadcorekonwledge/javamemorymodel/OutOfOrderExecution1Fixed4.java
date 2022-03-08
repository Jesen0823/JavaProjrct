package threadcorekonwledge.javamemorymodel;

import java.util.concurrent.CountDownLatch;

/**
 * 演示重排序
 * 三种情况：
 * x=0,y=1
 * x=1,y=0
 * x=1,y=1(条件：需要两个线程同时开始，需要工具类闸门效果)
 *罕见情况：发生了重排序：
 * x = 0,y = 0
 *
 * volatile 禁止了重排序
 * */
public class OutOfOrderExecution1Fixed4 {
    private volatile static int x = 0, y = 0;
    private volatile static int a = 0, b= 0;

    public static void main(String[] args) throws InterruptedException {
        int count = 0; // 运行次数记录
        for (; ; ) {
            count++;
            // 数据复原
            x = 0;
            y = 0;
            a = 0;
            b = 0;


            CountDownLatch latch = new CountDownLatch(1);

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            });
            t1.start();
            t2.start();
            latch.countDown();
            t1.join();
            t2.join();
            System.out.println("|count:"+count+"| x:y="+x+":"+y);
            if (x == 0 && y == 0){
                System.out.println("x:" + x + " y:" + y);
                break;
            }
            System.out.println("x:" + x + " y:" + y);
        }
    }
}
