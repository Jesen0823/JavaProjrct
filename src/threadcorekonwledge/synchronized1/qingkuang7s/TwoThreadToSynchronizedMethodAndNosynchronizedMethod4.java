package threadcorekonwledge.synchronized1.qingkuang7s;
/**
 * 两个线程访问 同步方法与非同步方法 的情况
 * 结果：同一个对象的同步方法和非同步方法如果同时执行，synchronized只影响同步方法，普通方法不受影响不会同步
 * */
public class TwoThreadToSynchronizedMethodAndNosynchronizedMethod4 implements Runnable{

    static TwoThreadToSynchronizedMethodAndNosynchronizedMethod4 instance = new TwoThreadToSynchronizedMethodAndNosynchronizedMethod4();
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else {
            method2();
        }
    }

    public synchronized void method1(){
        System.out.println("方法锁的形式，name:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public void method2(){
        System.out.println("普通方法，没加锁，name:"+Thread.currentThread().getName());
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
