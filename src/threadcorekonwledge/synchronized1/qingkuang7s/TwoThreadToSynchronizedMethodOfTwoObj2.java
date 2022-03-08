package threadcorekonwledge.synchronized1.qingkuang7s;
/**
 * 两个线程访问两个对象的同步方法，怎么同步
 * 结果：因为是两个对象的this,所以跟没有同步是一样的效果，互不干扰独立运行
 * */
public class TwoThreadToSynchronizedMethodOfTwoObj2 implements Runnable{

    static TwoThreadToSynchronizedMethodOfTwoObj2 instance1 = new TwoThreadToSynchronizedMethodOfTwoObj2();
    static TwoThreadToSynchronizedMethodOfTwoObj2 instance2 = new TwoThreadToSynchronizedMethodOfTwoObj2();

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("对象锁的代码块形式，" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("运行结束，" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished.");

    }
}
