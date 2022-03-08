package threadcorekonwledge.synchronized1;
/**
 * 类锁的第二种形式，class类对象形式
 *
 * */
public class SynchonizedClassClass6 implements Runnable{

    static SynchornizedClassStaticMethod5 instance1 = new SynchornizedClassStaticMethod5();
    static SynchornizedClassStaticMethod5 instance2 = new SynchornizedClassStaticMethod5();

    @Override
    public void run() {
        method();
    }

    private void method(){
        synchronized (SynchonizedClassClass6.class){
            System.out.println("类锁的class形式，name:"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
    }
}
