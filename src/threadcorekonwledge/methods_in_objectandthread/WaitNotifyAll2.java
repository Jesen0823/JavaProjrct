package threadcorekonwledge.methods_in_objectandthread;
/**
 * 3个线程，1和2阻塞，3去唤醒他们，用notify和notifyAll
 * 同时证明：start先执行不代表线程先启动
 * */
public class WaitNotifyAll2 implements Runnable{

    private static final Object resourceA = new Object();
    @Override
    public void run() {
        synchronized (resourceA){
            System.out.println(Thread.currentThread().getName()+"获取到锁");
            try {
                System.out.println(Thread.currentThread().getName()+"准备释放锁");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName()+"又拿到了锁，继续运行，准备结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new WaitNotifyAll2();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    resourceA.notifyAll();
                     System.out.println("线程3已经notifyAll");
                }
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(200); //为了保证让线程1和2先执行
        thread3.start();
    }
}
