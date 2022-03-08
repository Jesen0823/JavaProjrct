package threadcorekonwledge.thread_8core_konwledge;
/**
 * 证明wait只释放当前那把锁
 * */
public class WaitNotifyReleaseQwnMonitor {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("线程1拿到了A对象的锁");
                }
                synchronized (resourceB){
                    System.out.println("线程1拿到了B对象的锁");
                    try {
                        System.out.println("线程1准备wait释放对象A的锁...");
                        System.out.println("A的锁已经释放");
                        resourceA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000); //先执行线程1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2尝试获取A对象的锁，结果：");
                synchronized (resourceA){
                    System.out.println("线程2获取到A的锁，说明线程1执行wait确实释放了A的锁");
                    System.out.println("线程2尝试获取B对象的锁，结果：");
                    synchronized (resourceB){
                        System.out.println("线程2获取到B的锁，说明线程1执行wait也确实释放了B的锁");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

    }

}
