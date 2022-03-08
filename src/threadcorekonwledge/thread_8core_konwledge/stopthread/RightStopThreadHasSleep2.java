package threadcorekonwledge.thread_8core_konwledge.stopthread;
/**
 * 情况2：run方法带有sleep的线程如何中断
 * [InterruptedException: sleep interrupted]
 * 如果catch了异常，会正常中断并捕获异常
 * */
public class RightStopThreadHasSleep2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            int num = 0;
            try {
                while (num <= 300 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
