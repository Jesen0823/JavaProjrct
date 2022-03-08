package threadcorekonwledge.thread_8core_konwledge.stopthread;
/**
 * 情况一：run方法内没有sleep或wait方法时如何停止线程
 * 使用interrupt()中断线程，且判断是否已经调用过interrupt方法isInterrupted
 * */
public class RightStopThreadNoSleep1 implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightStopThreadNoSleep1());
        thread.start();
        Thread.sleep(500); //为了使线程慢点运行
        thread.interrupt();
    }


    @Override
    public void run() {
        int num = 0;
        while ((!Thread.currentThread().isInterrupted()) && num < Integer.MAX_VALUE/2){
            if (num % 1000 == 0){
                System.out.println(num+"是10000的倍数");
            }
            num++;
        }
        System.out.println("任务完成.");
    }
}
