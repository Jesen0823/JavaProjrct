package threadcorekonwledge.methods_in_objectandthread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/******************* sleep方法响应中断： *********************
 * 1.抛出InterruptedException
 * 2.清除中断状态
 * 结论：
 * sleep方法可以让线程进入waiting状态，并且不占用cpu资源，但是不释放锁，直到规定时间后再执行，
 * 休眠期间如果被中断，会抛出异常并清除中断状态
 *
 * 每隔1s输出当前事件，被中断，观察
 * */
public class SleepInterrupted7 implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepInterrupted7());
        thread.start();
        Thread.sleep(6500);
        thread.interrupt();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(new Date());
            try {
                // Thread.sleep的第二种写法：
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"被中断了");
                e.printStackTrace();
            }
        }
    }
}
