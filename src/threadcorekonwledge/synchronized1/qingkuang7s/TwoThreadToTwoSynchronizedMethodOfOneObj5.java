package threadcorekonwledge.synchronized1.qingkuang7s;
/**
 * 两个线程访问同一个对象的不同的 普通同步方法
 * 结果：也是同步的，因为方法锁对象是this,同一个对象的this是一样的。所以是同一个锁对象
 * */
public class TwoThreadToTwoSynchronizedMethodOfOneObj5 implements Runnable {

    static TwoThreadToTwoSynchronizedMethodOfOneObj5 instance = new TwoThreadToTwoSynchronizedMethodOfOneObj5();
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else {
            method2();
        }
    }

    public synchronized void method1(){
        System.out.println("方法锁的形式method1，name:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public synchronized void method2(){
        System.out.println("方法锁的形式method2，name:"+Thread.currentThread().getName());
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
