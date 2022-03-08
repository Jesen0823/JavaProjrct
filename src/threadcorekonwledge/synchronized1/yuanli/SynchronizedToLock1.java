package threadcorekonwledge.synchronized1.yuanli;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 加锁释放锁的原理展示：将Synchronized原理用Lock表示出来
 * 方法1和方法2是等价的
 * */
public class SynchronizedToLock1 {
    Lock lock = new ReentrantLock();

    public synchronized void method1(){
        System.out.println("Synchronized形式的锁");
    }

    public void method2(){
        lock.lock(); // 获取锁，锁住了
        try {
            System.out.println("Lock形式的锁");
        }finally {
            lock.unlock(); //释放锁
        }
    }

    public static void main(String[] args) {
        SynchronizedToLock1 s = new SynchronizedToLock1();
        s.method1();
        s.method2();
    }
}
