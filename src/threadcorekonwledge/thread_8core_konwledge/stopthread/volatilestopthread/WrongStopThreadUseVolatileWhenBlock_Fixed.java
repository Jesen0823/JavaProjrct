package threadcorekonwledge.thread_8core_konwledge.stopthread.volatilestopthread;

import threadcorekonwledge.stopthread.volitiledemo.WrongWayVolatileCantStopFixed;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用volatile的局限2：陷入阻塞时，volatile无法中断线程
 * 案例中,生产者速度很快，消费者速度很慢，阻塞队列满了生t产者会阻塞
 * */
public class WrongStopThreadUseVolatileWhenBlock_Fixed {
    public static void main(String[] args) throws InterruptedException {

        WrongStopThreadUseVolatileWhenBlock_Fixed body = new WrongStopThreadUseVolatileWhenBlock_Fixed();

        ArrayBlockingQueue queue = new ArrayBlockingQueue(9);
        Producer producer = body.new Producer(queue);
        Thread proThread = new Thread(producer);
        proThread.start();
        Thread.sleep(1000);

        Consumer consumer = body.new Consumer(queue);
        while (consumer.needMoreNums()){
            System.out.println(consumer.storage.take()+"被消费");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据,让生产者停下来");
        proThread.interrupt();
        producer.canceled = true;

    }

     class Producer implements Runnable{
        public volatile boolean canceled = false;
        private BlockingQueue storage;

        public Producer(BlockingQueue storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            int num = 0;
            try {
                while (num < 100000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        storage.put(num); //阻塞在这里，进不到while
                        System.out.println(num + "是100的倍数,放入仓库");
                    }
                    num++;
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                System.out.println("生产者停止运行");
            }
        }
    }

    class Consumer{
        BlockingQueue storage;

        public Consumer(BlockingQueue storage) {
            this.storage = storage;
        }

        public boolean needMoreNums(){
            if (Math.random() > 0.95){
                return false;
            }
            return true;
        }
    }
}


