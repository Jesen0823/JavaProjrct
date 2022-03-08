package threadcorekonwledge.synchronized1.qingkuang7s;
/**
 * Synchronized方法抛出异常后会释放锁吗，抛出异常前和抛出异常后的对比
 * 结果：会主动释放锁。线程异常时，jvm会把锁主动释放
 * */
public class  IsOutLockIfSynchronizedException7 implements Runnable{

    static IsOutLockIfSynchronizedException7 instance = new IsOutLockIfSynchronizedException7();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else {
            method2();
        }
    }

    public synchronized void method1(){
        System.out.println("方法锁的形式method1，name:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
            throw new Exception(); //主动抛出一个异常
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public synchronized void method2(){
        System.out.println("方法锁的形式method2，name:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        System.out.println("finished.");
    }
}
