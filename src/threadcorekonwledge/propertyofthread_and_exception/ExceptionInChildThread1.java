package threadcorekonwledge.propertyofthread_and_exception;
/**
 * 主线程会抛出遇到的异常有异常堆栈
 * 子线程发生异常会如何？
 * */
public class ExceptionInChildThread1 implements Runnable{

    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread1()).start();
        for (int i=0;i<100;i++){
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
