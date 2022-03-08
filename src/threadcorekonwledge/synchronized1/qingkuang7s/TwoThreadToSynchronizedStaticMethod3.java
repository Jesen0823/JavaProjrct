package threadcorekonwledge.synchronized1.qingkuang7s;
/**
 * 两个线程访问Synchronized的静态方法，怎么同步
 * 结果：虽然是两个对象的锁，但两个对象属于同一个类，static方法锁属于类锁，本质上是同一个类锁，是同步的
 * */
public class TwoThreadToSynchronizedStaticMethod3 implements Runnable {

    static TwoThreadToSynchronizedStaticMethod3 instance1 = new TwoThreadToSynchronizedStaticMethod3();
    static TwoThreadToSynchronizedStaticMethod3 instance2 = new TwoThreadToSynchronizedStaticMethod3();
    @Override
    public void run() {
        method();
    }

    public static synchronized void method(){
        System.out.println("类锁的静态方法形式，name:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();

    }
}
