package threadcorekonwledge.methods_in_objectandthread;

/**
 * 演示join被中断的效果
 *
 * */
public class JoinInterrupt9 {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread(); // 主线程
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mainThread.interrupt(); // 子线程对主线程进行中断
                    Thread.sleep(5000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                } catch (InterruptedException e) {
                    System.out.println("子线程中断");
                    //e.printStackTrace();
                }
            }
        });
        thread1.start();
        System.out.println("等待子线程运行完毕");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("主线程 "+Thread.currentThread().getName()+"被中断了");
            //e.printStackTrace();
            System.out.println("主线程将中断通知给子线程，把子线程中断：");
            thread1.interrupt();
        }
        System.out.println("子线程运行完毕");

    }
}
