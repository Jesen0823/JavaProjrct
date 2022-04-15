package threadcorekonwledge.methods_in_objectandthread;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerModel5 {

    private int queueSize = 10;
    private volatile ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args) {
        ProducerConsumerModel5 producerConsumer = new ProducerConsumerModel5();
        Producer producer = producerConsumer.new Producer();
        Consumer consumer = producerConsumer.new Consumer();
        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Integer take = queue.take();
                    System.out.println("Consumer 消费掉 1个 " + take + ", 剩余：" + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.put(2);
                    System.out.println("Producer 生产了 1个 , 剩余：" + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
