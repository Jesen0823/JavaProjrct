package threadcorekonwledge.propertyofthread_and_exception;
/**
 * 使用自定义未捕获异常处理器 MyUncaughtExceptionHandler3
 * */
public class MyUncaughtExceptionUse3 implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler3("[BUHUOQI]"));

        new Thread(new MyUncaughtExceptionUse3(), "thread_01").start();
        Thread.sleep(300);
        new Thread(new MyUncaughtExceptionUse3(), "thread_02").start();
        Thread.sleep(300);
        new Thread(new MyUncaughtExceptionUse3(), "thread_03").start();
        Thread.sleep(300);
        new Thread(new MyUncaughtExceptionUse3(), "thread_04").start();
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
