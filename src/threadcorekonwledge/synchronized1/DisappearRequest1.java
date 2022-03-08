package threadcorekonwledge.synchronized1;

/**
 * 两个线程操作同一个对象i,没有高并发控制的效果，结果小于200000
 * 解决办法：
 * 1.run方法加上synchornized
 * 2.synchornized(this)代码块
 * 3.synchornized(.class)代码块,类锁
 * */
public class DisappearRequest1 implements Runnable{

    static DisappearRequest1 instance = new DisappearRequest1();
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("都执行完了，i="+i);
    }

    @Override
    public void run() {
        for (int j=0; j< 100000; j++){
            i++;
        }
    }
}