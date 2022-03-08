package threadcorekonwledge.methods_in_objectandthread;
/**
 * 用wait/notify实现，两个线程交替打印奇数偶数，效率更高
 * */
public class WaitNotifyPrintOddEvenWait4 {
    // 拿到锁就去打印，打印完，唤醒其他线程，自己休眠
    public static void main(String[] args) {
        new Thread(new TurningRunner(), "偶数").start();
        new Thread(new TurningRunner(),"奇数").start();
    }

    static class TurningRunner implements Runnable{
        private static int count = 0;
        private static final Object lock = new Object();

        @Override
        public void run() {
            while (count <= 100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+":" + count++);
                    lock.notify();
                    if (count <= 100){
                        try {
                            // 如果任务还没结束，当前线程让出锁
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
