package threadcorekonwledge.lifeofthread;
/**
 * 展示线程另外三种状态：Block,Waiting,TimedWaiting
 * */
public class BlockedWaitingTimedWaiting implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        BlockedWaitingTimedWaiting r = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        Thread.sleep(10); // 让线程慢点运行
        System.out.println("[LOG-01]: t1,"+thread1.getState()); // TIMED_WAITING
        System.out.println("[LOG-01]: t2,"+thread2.getState()); // BLOCKED
        Thread.sleep(1300);
        System.out.println("[LOG-02]: t1,"+thread1.getState()); //
        System.out.println("[LOG-02]: t2,"+thread2.getState()); //
    }

    @Override
    public void run() {
        meth();
    }

    private synchronized void meth(){
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
