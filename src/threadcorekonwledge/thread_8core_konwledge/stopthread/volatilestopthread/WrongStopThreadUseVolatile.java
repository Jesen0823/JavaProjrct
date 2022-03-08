package threadcorekonwledge.thread_8core_konwledge.stopthread.volatilestopthread;
/**
 * volatile的局限
 * */
public class WrongStopThreadUseVolatile implements Runnable{
    private volatile boolean canceled = false;

    public static void main(String[] args) throws InterruptedException {
        WrongStopThreadUseVolatile instance = new WrongStopThreadUseVolatile();
        Thread thread = new Thread(instance);
        thread.start();
        Thread.sleep(5000);
        instance.canceled = true;
    }
    @Override
    public void run() {
        int num = 0;
        try {
            while (num < 100000 && !canceled) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(1);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
