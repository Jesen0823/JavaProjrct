package threadcorekonwledge.stopthread;
/**
 * 实际应用中正确地终止线程
 *
 * 最佳实践2：
 * 如果不想中断，在catch语句中调用Thread.currentThread().interrupt()来恢复中断
 * 以便后续执行中依然能够检查到刚刚发生了中断
* */
public class RightWayStopThreadInProd2 implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        // sleep函数会清除interrupt的标志位，所以要判断interrupted
        // 2.run方法特殊，中无法抛出一个异常,只能try/catch
        while (true){
            if (Thread.currentThread().isInterrupted()){
                System.out.println("isInterrupt，程序运行结束.");
                break;
            }
            System.out.println(String.format("now:" + System.currentTimeMillis(), "yyyy-MM-dd"));
            reInterrupt();
            System.out.println("save log.");
        }
    }

    private void reInterrupt() {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private void methodSecond() throws InterruptedException {
        Thread.sleep(2000);
    }
}
