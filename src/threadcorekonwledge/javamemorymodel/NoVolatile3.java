package threadcorekonwledge.javamemorymodel;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不适用volatile的情况
 * */
public class NoVolatile3 implements Runnable{
    volatile int a = 0;
    //对比变量
    AtomicInteger realCount = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            a++;
            realCount.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NoVolatile3 r = new NoVolatile3();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("结果值："+r.a);
        System.out.println("真实值："+r.realCount.get());
    }
}
