package threadcorekonwledge.deadlock;
/**
 * 必然死锁的例子
 * */
public class MustDeadLock1 implements Runnable{
    private int flag;
    static Object lock1 = new Object();
    static Object lock2 = new Object();
    public static void main(String[] args) {
        MustDeadLock1 r1 = new MustDeadLock1();
        r1.flag = 1;
        MustDeadLock1 r2 = new MustDeadLock1();
        r2.flag = 2;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
    @Override
    public void run() {
        if (flag == 1){
            synchronized (lock1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("t1线程拿到了lock2");
                }
            }
        }
        if (flag == 2){
            synchronized (lock2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("t2线程拿到了lock1");
                }
            }
        }
    }
}
