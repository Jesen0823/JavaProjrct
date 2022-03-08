package threadcorekonwledge.methods_in_objectandthread;
/**
 * 演示join 注意语句输出顺序
 * */
public class Join8 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"  2执行完毕");
            }
        });
        thread1.start();
        thread2.start();
        System.out.println("开始等待子线程运行完毕");
        // 主线程main等待这两个子线程完毕再继续
        thread1.join();
        thread2.join();

    }
}
