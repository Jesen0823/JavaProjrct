package threadcorekonwledge.stopthread.volitiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 用中断来修复volatile无限等待，无法结束的问题
 * */
public class WrongWayVolatileCantStopFixed {
    public static void main(String[] args) throws InterruptedException{
        WrongWayVolatileCantStopFixed body = new WrongWayVolatileCantStopFixed();
        // 仓库
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);

        Producer producer = body.new Producer(queue);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000); // 等待生产即塞满队列

        Consumer consumer = body.new Consumer(queue);
        while (consumer.needMoreNums()){
            System.out.println(consumer.storage.take() + "已经被消费");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多产品了");

        // 一旦消费者不需要更多了，生产者应该停下来
        producerThread.interrupt();
    }

    public class Producer implements Runnable{
        public volatile boolean canceled = false;
        BlockingQueue storage;

        public Producer(BlockingQueue storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            int num = 0;
            try {
                while (num <= 100000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        storage.put(num);
                        System.out.println(num + "是100的倍数,已入库");
                    }
                    num++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(num + "生产者结束");
            }
        }
    }

    public class Consumer{
        public BlockingQueue storage;

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


