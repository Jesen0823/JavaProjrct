package threadcorekonwledge.thread_8core_konwledge.stopthread;
/**
 * 如果while里面try/catch 会导致中断失效
 * 原因：sleep会清除interrupt中断标记位
 * 那如何才能中断？
 * 1.传递中断 2.恢复中断 3.不该屏蔽中断
 * */
public class CanInterrupter4 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            int num = 0;
                while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                    try{
                    Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
}
}
