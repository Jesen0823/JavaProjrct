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
                    // 恢复中断
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
        }).start();
    }
}
