package juc.thread;

import java.util.concurrent.TimeUnit;
/**
 * volatile 标志位中断线程
 * */
public class InteruptThread1 {

    static volatile  boolean isStop = false;

    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                if (isStop){
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
            isStop = true;
        },"t2").start();
    }
}
