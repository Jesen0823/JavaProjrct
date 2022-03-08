package threadcorekonwledge.stopthread;
/**
 *  如果在执行中，每次循环都sleep或wait阻塞，如何停止线程
 *
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException{
        Runnable runnable = ()->{
            int num = 0;
            try {
                while (num <= 10000){
                    if (num % 100 == 0){
                        System.out.println(num+"是100 倍数");
                    }
                    num++;
                    Thread.sleep(10);

                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
