package threadcorekonwledge.methods_in_objectandthread;

import java.util.PriorityQueue;

public class ProducerConsumerModel4 {
    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);

    public static void main(String[] args) {
        ProducerConsumerModel4 producerConsumer = new ProducerConsumerModel4();
        Producer producer = producerConsumer.new Producer();
        Consumer consumer = producerConsumer.new Consumer();
        producer.start();
        consumer.start();
    }

    class Consumer extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    while (queue.size() == 0){
                        try {
                            System.out.println("Consumer 队列空了 等待数据"+", 当前队列大小："+queue.size());
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    // 移走队首元素
                    Integer poll = queue.poll();
                    System.out.println("Consumer, 消费一个："+poll+", 当前队列大小："+queue.size());
                    queue.notify();
                }
            }
        }
    }

    class Producer extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (queue){
                    while (queue.size() == queueSize){
                        try {
                            System.out.println("Producer 队列满了，快来消费"+", 当前队列大小："+queue.size());
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 插入一个元素
                    boolean offer = queue.offer(1);
                    if (offer){
                        System.out.println("Producer, 生产1个"+", 当前队列大小："+queue.size());
                    }
                    queue.notify();
                }
            }
        }
    }
}
