package threadcorekonwledge.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 演示用ThreadMXBean寻找死锁
 * */
public class ThreadMXBeanDetection4 implements Runnable {
    private int flag;
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        ThreadMXBeanDetection4 r1 = new ThreadMXBeanDetection4();
        r1.flag = 1;
        ThreadMXBeanDetection4 r2 = new ThreadMXBeanDetection4();
        r2.flag = 2;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        Thread.sleep(1000); //等待发生死锁
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        if (deadlockedThreads != null && deadlockedThreads.length > 0){
            for (int i =0; i< deadlockedThreads.length;i++){
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThreads[i]);
                System.out.println(threadInfo.getThreadName());
            }
        }
    }
    @Override
    public void run() {
        if (flag == 1){
            synchronized (lock1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("t1线程拿到了lock2");
                }
            }
        }
        if (flag == 2){
            synchronized (lock2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("t2线程拿到了lock1");
                }
            }
        }
    }
}
