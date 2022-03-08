package threadcorekonwledge.methods_in_objectandthread;
/**
 *  用synchronized实现，两个线程交替打印奇数偶数
 * */
public class WaitNotifyPrintOddEvenSyn4 {
    private static int count; // static是因为两个线程共享一个变量
    private static final Object lock = new Object();

    // 建立两个线程，奇数偶数用位运算，用synchronized通讯
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100){
                    synchronized (lock){
                        if ((count & 1) == 0){ // 偶数，位运算
                            System.out.println(Thread.currentThread().getName() + ":"+count);
                            count ++;
                        }
                    }
                }
            }
        },"ouShu").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100){
                    synchronized (lock){
                        if ((count & 1) == 1){ // 奇数，位运算
                            System.out.println(Thread.currentThread().getName() + ":"+count);
                            count ++;
                        }
                    }
                }
            }
        },"jiShu").start();


    }

}
