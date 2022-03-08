package threadcorekonwledge.synchronized1.qingkuang7s;
/**
 * 两个线程同时访问 静态Synchronized和 非静态Synchronized方法
 *
 * 结果：虽然加了同步关键字Synchronized，但是类锁和对象锁不是同一个锁，所以不会同步
 * */
public class TwoThreadToAStaticSynchronizedAndNoStaticSynchronized6 implements Runnable{

    static TwoThreadToAStaticSynchronizedAndNoStaticSynchronized6 instance = new TwoThreadToAStaticSynchronizedAndNoStaticSynchronized6();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else {
            method2();
        }
    }

    public static synchronized void method1(){
        System.out.println("静态方法锁的形式method1，name:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public synchronized void method2(){
        System.out.println("方法锁的形式method2非静态，name:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        System.out.println("finished.");
    }
}
