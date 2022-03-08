package threadcorekonwledge.deadlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用tryLock来避免死锁
 */
public class TryLockDeadlock6 implements Runnable {
    int flag = 1;
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (flag == 1) {
                try {
                    if (lock1.tryLock(800, TimeUnit.MICROSECONDS)) {
                        System.out.println("线程1获取到锁1成功");
                        Thread.sleep(new Random().nextInt(1000));
                        if (lock2.tryLock(800, TimeUnit.MICROSECONDS)) {
                            System.out.println("线程1获取到锁2也成功");
                            lock2.unlock();
                            lock1.unlock();
                            System.out.println("线程1释放了两把锁");
                            break;
                        }else {
                            System.out.println("线程1获取到锁2失败，已重试");
                            lock1.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    }else {
                        System.out.println("线程1获取到锁1失败，已重试");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (flag == 0) {
                try {
                    if (lock2.tryLock(800, TimeUnit.MICROSECONDS)) {
                        System.out.println("线程2获取到锁2成功");
                        Thread.sleep(new Random().nextInt(1000));
                        if (lock1.tryLock(800, TimeUnit.MICROSECONDS)) {
                            System.out.println("线程2获取到锁1也成功");
                            lock1.unlock();
                            lock2.unlock();
                            System.out.println("线程2释放了两把锁");
                            break;
                        }else {
                            System.out.println("线程2获取到锁1失败，已重试");
                            lock2.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    }else {
                        System.out.println("线程2获取到锁2失败，已重试");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        TryLockDeadlock6 r1 =new TryLockDeadlock6();
        TryLockDeadlock6 r2 = new TryLockDeadlock6();
        r1.flag = 1;
        r2.flag = 0;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
