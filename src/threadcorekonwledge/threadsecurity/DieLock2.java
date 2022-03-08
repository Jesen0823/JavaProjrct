package threadcorekonwledge.threadsecurity;
/**
 * 死锁的例子
 * */
public class DieLock2 implements Runnable {
    int flag = 1;
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
        DieLock2 r1 = new DieLock2();
        DieLock2 r2 = new DieLock2();
        r1.flag = 1;
        r2.flag = 0;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }


    @Override
    public void run() {
        System.out.println("flag="+flag);
        if (flag == 1) {
            synchronized (lock1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("OK-1");
                }
            }
        }

        if (flag == 0){
            synchronized (lock2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("OK-0");
                }
            }
        }
    }
}
