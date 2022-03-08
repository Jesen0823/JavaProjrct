package threadcorekonwledge.thread_8core_konwledge.stopthread;
/**
 * run()无法抛出checked Exception,只能用try/catch
 * */
public class RunThrowException5 {
    //普通方法
    public void method1() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
