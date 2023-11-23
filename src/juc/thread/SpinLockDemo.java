package juc.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁 a
 */
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void mylock() {
        System.out.println(Thread.currentThread().getName() + ", comming in.");

        while (!atomicReference.compareAndSet(null, Thread.currentThread())) {
            System.out.println(Thread.currentThread().getName() + ", try again...");
        }
        System.out.println(Thread.currentThread().getName() + ", hold lock.");
    }

    public void myUnLock(){
        atomicReference.compareAndSet(Thread.currentThread(),null);
        System.out.println(Thread.currentThread().getName()+", release lock");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.mylock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        },"t1").start();

        // t1线程划水滑了3秒，所以t2线程原地转圈圈，自旋等待
        new Thread(()->{
            spinLockDemo.mylock();
            spinLockDemo.myUnLock();
        },"t2").start();
    }
}
