package juc.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * automatic 标志位中断线程
 * */
public class InteruptThread2 {

    static AtomicBoolean isStop = new AtomicBoolean(false);

    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                if (isStop.get()){
                    System.out.println(Thread.currentThread().getName()+"---isStop true.");
                    break;
                }
                System.out.println(Thread.currentThread().getName()+" running...");
            }
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            isStop.set(true);
        },"t2").start();
    }
}
