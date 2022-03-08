package threadcorekonwledge.synchronized1;
/**
 * 对象锁示例2，方法锁，直接给方法synchronized
 * 注意只能修饰普通方法，不能是静态方法，锁对象默认为this
 * */
public class SynchronizedObjectMethod4 implements Runnable{
    static SynchronizedObjectMethod4 instance = new SynchronizedObjectMethod4();

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
