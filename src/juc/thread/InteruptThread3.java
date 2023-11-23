package juc.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * interrupt() 标志位中断线程
 * */
public class InteruptThread3 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "---isStop true.");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " running...");
            }
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            t1.interrupt();
        },"t2").start();
    }
}
