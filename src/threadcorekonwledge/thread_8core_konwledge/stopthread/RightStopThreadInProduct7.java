package threadcorekonwledge.thread_8core_konwledge.stopthread;
/**
 * 生产实践中恢复中断：catch语句中调用Thread.currentThread().interrupted
 * 来恢复设置中断状态，以便后续执行中依然能够检查到刚才发生了中断
 * */
public class RightStopThreadInProduct7 implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightStopThreadInProduct7());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true){
            if (Thread.currentThread().isInterrupted()){
                System.out.println("interrupted,运行结束");
                break;
            }
            System.out.println("do...");
            throwInMethod();
        }
    }

    private void throwInMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // 重新恢复中断,使得中断标记恢复，isInterrupted能够检查到
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
