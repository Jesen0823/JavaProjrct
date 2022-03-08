package threadcorekonwledge.synchronized1.yuanli;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 展示对比Lock锁的优点
 * */
public class LockExample3 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        lock.tryLock();
        try {
            lock.tryLock(1000, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.newCondition();
    }
}
