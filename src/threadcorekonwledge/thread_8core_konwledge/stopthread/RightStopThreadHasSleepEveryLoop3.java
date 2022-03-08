package threadcorekonwledge.thread_8core_konwledge.stopthread;
/**
 * 如果在执行过程中，每次循环都会sleep或wait等方法
 * 在休眠中interrupter会立马响应中断并抛出异常，不需要检查isInterrupted
 * */
public class RightStopThreadHasSleepEveryLoop3 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            int num = 0;
            try {
                while (num <= 10000) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
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
