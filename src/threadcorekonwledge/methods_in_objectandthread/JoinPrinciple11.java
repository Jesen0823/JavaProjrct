package threadcorekonwledge.methods_in_objectandthread;
/**
 * 通过讲解join原理，分析出join的代替写法
 * */
public class JoinPrinciple11 {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"运行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        System.out.println("等待子线程执行完毕");
        //thread1.join();
        // 等级代码
        synchronized (thread1){
            thread1.wait(); // 子线程执行完run会唤醒主线程
        }
        System.out.println("所有子线程执行完毕");

    }
}
