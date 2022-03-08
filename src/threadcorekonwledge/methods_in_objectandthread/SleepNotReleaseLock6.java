package threadcorekonwledge.methods_in_objectandthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 展示线程sleep的时候不释放lock的monitor,等sleep正常结束后才释放锁(lock需要手动释放)
 * 结论：sleep和wait不同，sleep不会释放锁，而wait会释放锁
 * */
public class SleepNotReleaseLock6 implements Runnable{

    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        SleepNotReleaseLock6 sleepNotReleaseLock = new SleepNotReleaseLock6();
        new Thread(sleepNotReleaseLock).start();
        new Thread(sleepNotReleaseLock).start();
    }

    @Override
    public void run() {
        syn();
    }

    private void syn(){
        LOCK.lock();
        System.out.println("线程"+ Thread.currentThread().getName()+"获取到了lock");
        try {
            Thread.sleep(5000);
            System.out.println("线程"+ Thread.currentThread().getName()+"已经苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            LOCK.unlock();
        }
        System.out.println("线程"+ Thread.currentThread().getName()+"退出run");

    }
}
