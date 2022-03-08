package threadcorekonwledge.thread_8core_konwledge.stopthread;
/**
 * 生产实践中传递中断：catch了InterruptedException后优先选择
 * 在方法签名处抛出异常，那么在run中就会强制要求try/catch
 * */
public class RightStopThreadInProduct6 implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightStopThreadInProduct6());
        thread.start();
        Thread.sleep(1000);
        thread.isInterrupted();
    }

    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()){
            System.out.println("do...");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }
}
