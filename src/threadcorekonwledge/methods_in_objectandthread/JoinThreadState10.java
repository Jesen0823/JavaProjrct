package threadcorekonwledge.methods_in_objectandthread;
/**
 *
 * join的线程状态，先join再获取线程状态，或者通过debugger调试
 * */
public class JoinThreadState10 {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(mainThread.getName()+"状态："+mainThread.getState());
                    System.out.println(Thread.currentThread().getName()+"运行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        System.out.println("等待子线程执行完毕");
        thread1.join();
        System.out.println("子线程执行完毕");

    }
}
