package threadcorekonwledge.methods_in_objectandthread;
/**
 * 展示线程sleep的时候不释放synchronized的monitor,线程正常结束后才释放锁
 * 结论：sleep和wait不同，sleep不会释放锁，而wait会释放锁
 * */
public class SleepNotReleaseMonitor5 implements Runnable{

    public static void main(String[] args) {
        SleepNotReleaseMonitor5 sleepNotReleaseMonitor = new SleepNotReleaseMonitor5();
        new Thread(sleepNotReleaseMonitor).start();
        new Thread(sleepNotReleaseMonitor).start();
    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn(){
        System.out.println("线程"+ Thread.currentThread().getName()+"获取到了monitor");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+ Thread.currentThread().getName()+"退出同步代码块");

    }
}
