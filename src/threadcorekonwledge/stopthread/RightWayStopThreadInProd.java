package threadcorekonwledge.stopthread;
/**
 * 实际应用中正确地终止线程
 *
 * 最佳实践：
 * catch了InterruptedException之后的优先选择：
 * 在方法签名中抛出异常，那么调用方法的run()会强制try/catch
 * */
public class RightWayStopThreadInProd implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        // sleep函数会清除interrupt的标志位，所以要判断interrupted
        // 2.run方法特殊，中无法抛出一个异常,只能try/catch
        while (true && !Thread.currentThread().isInterrupted()){
            System.out.println(String.format("now:" + System.currentTimeMillis(), "yyyy-MM-dd"));
            //methodFirst();
            try {
                methodSecond();
            } catch (InterruptedException e) {
                System.out.println("save log.");
                e.printStackTrace();
            }
        }
    }

    private void methodFirst() {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void methodSecond() throws InterruptedException {
        Thread.sleep(2000);
    }
}
