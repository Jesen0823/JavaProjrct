package threadcorekonwledge.lifeofthread;
/**
 * 展示线程New Runnable Terminated状态
 * */
public class NewRunnableTerminated implements Runnable {


    public static void main(String[] args) {
        NewRunnableTerminated r = new NewRunnableTerminated();
        Thread thread = new Thread(r);
        System.out.println("GO-1：" + thread.getState());
        thread.start();
        System.out.println("GO-2：" + thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("GO-3：" + thread.getState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("GO-4：" + thread.getState());
    }
    @Override
    public void run() {
        for (int i =0; i < 1000;i++){
            System.out.println(i);
        }
    }
}
