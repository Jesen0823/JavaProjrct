package threadcorekonwledge.stopthread;
/**
 * 错误的停止线程方法，用stop停止线程，会导致线程运行一般突然停止，无法正常完成一个基本单位操作
 * */
public class StopThread implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }

    @Override
    public void run() {
        //一共5个连，每个连10个人，以连为单位以此发放武器
        for (int i = 0; i < 5; i++){
            System.out.println(i+ "连开始领取：");
            for (int j = 0; j < 10; j++){
                System.out.println(j+ "  士兵领取：");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i+ "连领取完毕！");
        }
    }
}
