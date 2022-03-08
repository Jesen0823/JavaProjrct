package threadcorekonwledge.propertyofthread_and_exception;
/**
 * id从1开始，JVM运行起来后，走吗自己创建的线程早已不是2
 * */
public class ThreadId1 {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("主线程的ID:"+Thread.currentThread().getId());
        System.out.println("子线程的ID:"+thread.getId());

    }
}
