package threadcorekonwledge.methods_in_objectandthread;
/**
 * 用wait和notify的基本用法
 * 1.研究代码执行顺序
 * 2.证明wait释放锁，wait只能用在synchronied代码块中
 * */
public class Wait1 {
    public static Object object = new Object();
    static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println("线程1，"+Thread.currentThread().getName()+"开始执行");
                try {
                    System.out.println("线程1准备释放锁");
                    object.wait(); // 执行到这里释放锁后下面不再执行，直到拿到锁继续后面的执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1，"+Thread.currentThread().getName()+"获取到了锁，即被唤醒");
            }
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                object.notify();
                System.out.println("线程2，"+ Thread.currentThread().getName()+"调用了notify");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        Thread.sleep(200); //只是为了保证线程1先执行
        thread2.start();
    }
}
