package threadcorekonwledge.thread_8core_konwledge.startthread;
/**
 * Start 和Run方法
 * */
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable = () ->{
            System.out.println("runnable " + Thread.currentThread().getName());
        };
        runnable.run();

        new Thread(runnable).start();
    }
}
