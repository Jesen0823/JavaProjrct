package juc.thread;

import java.util.concurrent.TimeUnit;

public class SleepInterruptDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true){
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("---isInterrupted true.");
                    break;
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    // t2启动后要中断t1,但是t1处于睡眠中,sleep()方法会清除中断位标记，所以中断失效，抛异常后接着运行，没停下来。那么
                    // 可以捕获中断异常InterruptedException后，恢复中断
                    // Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                System.out.println("----running...");
            }
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            t1.interrupt();
        },"t2").start();
    }
}
