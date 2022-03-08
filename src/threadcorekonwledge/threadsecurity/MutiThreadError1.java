package threadcorekonwledge.threadsecurity;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 运行结果出错
 * 演示计数结果不准确，找出出错位置
 * */
public class MutiThreadError1 implements Runnable{
    static MutiThreadError1 instance = new MutiThreadError1();
    int index = 0;
    final boolean[] markrd =new boolean[100000];
    // 原子整型
    static AtomicInteger realIndex = new AtomicInteger();
    static AtomicInteger wrongCount = new AtomicInteger();

    static volatile CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
    static volatile CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("result="+instance.index);
        System.out.println("real="+realIndex);
        System.out.println("wrong="+wrongCount);
    }

    @Override
    public void run() {
        markrd[0] = true;
        for (int i = 0; i < 10000;i++){
            try {
                cyclicBarrier2.reset();
                cyclicBarrier1.await();//闸门
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            index++;
            try {
                cyclicBarrier1.reset();
                cyclicBarrier2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            realIndex.incrementAndGet();//增加
            synchronized (instance) {
                if (markrd[index] && markrd[index-1]) {
                    wrongCount.incrementAndGet();
                    System.out.println("第" + index + "次发生错误");
                }
                markrd[index] = true;
            }
        }
    }
}
