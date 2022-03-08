package threadcorekonwledge.thread_8core_konwledge.startthread;
/**
 * 一个线程不能连续调用两次start(),会报错
 * */
public class NotStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
