package juc.thread;

import java.util.concurrent.TimeUnit;
/**
 * 【检测死锁方法1：】
 * 命令： jps -l   查看进程id
 * 命令： jstack [进程id] 检测死锁
 * 得到：
 * ===================================================
 * "t2":
 *         at juc.thread.DeadLockDemo.lambda$main$1(DeadLockDemo.java:34)
 *         - waiting to lock <0x000000076bea3178> (a java.lang.Object)
 *         - locked <0x000000076bea3188> (a java.lang.Object)
 *         at juc.thread.DeadLockDemo$$Lambda$2/1078694789.run(Unknown Source)
 *         at java.lang.Thread.run(Thread.java:748)
 * "t1":
 *         at juc.thread.DeadLockDemo.lambda$main$0(DeadLockDemo.java:20)
 *         - waiting to lock <0x000000076bea3188> (a java.lang.Object)
 *         - locked <0x000000076bea3178> (a java.lang.Object)
 *         at juc.thread.DeadLockDemo$$Lambda$1/990368553.run(Unknown Source)
 *         at java.lang.Thread.run(Thread.java:748)
 *
 * Found 1 deadlock.
 *
 * 【检测死锁方法2：】
 * win + R  输入 jconsole 打开jconsole工具查看线程状态检测死锁
 * */
public class DeadLockDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        new Thread(() -> {
            synchronized (o1) {
                try {
                    System.out.println(Thread.currentThread().getName() + "------get lock 1.\t");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "------get lock 2.\t");
                }
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o2) {
                try {
                    System.out.println(Thread.currentThread().getName() + "------get lock 2.\t");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "------get lock 1.\t");
                }
            }
        }, "t2").start();
    }
}
