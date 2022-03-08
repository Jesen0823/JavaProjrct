package threadcorekonwledge.thread_8core_konwledge.createthread;
/**
 * 用Runnable接口方式创建线程
 * */
public class RunnableStyle implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    @Override
    public void run() {

    }
}
