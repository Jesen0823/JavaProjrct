package threadcorekonwledge.thread_8core_konwledge.createthread;
/**
 * 使用Thread类创建线程
 * */
public class ThreadStyle extends Thread{

    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) {
        Thread thread = new ThreadStyle();
        thread.start();
    }
}
