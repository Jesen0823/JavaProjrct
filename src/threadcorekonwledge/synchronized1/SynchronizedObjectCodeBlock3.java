package threadcorekonwledge.synchronized1;
/**
 * 对象锁示例1：代码块形式,两个不同对象
 *
 *
 * */
public class SynchronizedObjectCodeBlock3 implements Runnable{
    static SynchronizedObjectCodeBlock3 instance = new SynchronizedObjectCodeBlock3();
    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("对象锁的代码块形式，" + Thread.currentThread().getName()+"获取lock1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock1 运行结束，" + Thread.currentThread().getName());
        }

        synchronized (lock2) {
            System.out.println("对象锁的代码块形式，" + Thread.currentThread().getName()+"获取lock2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock2 运行结束，" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

         }
        System.out.println("finished.");

    }
}
