package juc.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {

    static Object objectLock = new Object();

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        //objWN();

        //condition();

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ", running");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + ", weak");
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+", 发出唤醒");
            LockSupport.unpark(t1);
        },"t2").start();
    }

    private static void condition() {
        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ", running");
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

            System.out.println(Thread.currentThread().getName() + ", weak");

        }, "t1").start();

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            lock.lock();
            condition.signal();
            System.out.println(Thread.currentThread().getName()+" ,发出唤醒");
            lock.unlock();
        }, "t2").start();
    }

    private static void objWN() {
        new Thread(() -> {
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + ", running");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ", weak");
            }
        }, "t1").start();

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + ", notify");
            }
        }, "t2").start();
    }
}
