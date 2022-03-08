package threadcorekonwledge.synchronized1.qingkuang7s;
/**
 * 两个线程同时访问一个对象的同步方法的情况
 * 结果：一个线程运行完另一个再运行
 * */
public class TwoThreadToSynchronizedMethodOfOneObj1 implements Runnable {
    static TwoThreadToSynchronizedMethodOfOneObj1 instance = new TwoThreadToSynchronizedMethodOfOneObj1();
    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        System.out.println("finished.");
    }
    @Override
    public void run() {
        method();
    }

    public synchronized void method(){
        System.out.println("对象锁的方法修饰符形式，name:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}
