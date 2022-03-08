package threadcorekonwledge.propertyofthread_and_exception;
/**
 * 1.不加try/catch抛出4个异常
 * 2.加了try/catch，期望能捕获到第一个线程的异常，线程234不应该运行，期望打印出CaughtException
 * 3.发现没有CaughtException,线程234依然运行且抛出异常
 *
 * 说明线程的异常不能用传统方法捕获
 * */
public class CanCatchChildThreadException2 implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        try {
            new Thread(new CanCatchChildThreadException2(), "thread_01").start();
            Thread.sleep(300);
            new Thread(new CanCatchChildThreadException2(), "thread_02").start();
            Thread.sleep(300);
            new Thread(new CanCatchChildThreadException2(), "thread_03").start();
            Thread.sleep(300);
            new Thread(new CanCatchChildThreadException2(), "thread_04").start();
        }catch (RuntimeException e){
            System.out.println("Caught Exception");
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
