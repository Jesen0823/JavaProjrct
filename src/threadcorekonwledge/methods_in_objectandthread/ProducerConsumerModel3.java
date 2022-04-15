package threadcorekonwledge.methods_in_objectandthread;

import java.util.Date;
import java.util.LinkedList;

/**
 * 用wait/notify实现生产者消费者模式
 * */
public class ProducerConsumerModel3 {

    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Producer implements Runnable{

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            storage.put("Producer");
        }
    }
}

class Consumer implements Runnable{

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            storage.take("Consumer");
        }
    }
}


class EventStorage{
    private int maxSize;
    //private List<Date> storage; //List拿到后需要删除比较繁琐，考虑用linkList
    private LinkedList<Date> storage;
    public EventStorage(){
        maxSize = 10;
        //storage = new ArrayList<Date>();
        storage = new LinkedList<>();
    }

    /* 如果仓库满了就阻塞，如果没满就生产数据并通知对方*/
    public synchronized void put(String name){
        while (storage.size() == maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println(name+"添加了1个 仓库容量："+ storage.size());
        notify();
    }

    public synchronized void take(String name){
        while (storage.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /*System.out.println("拿到了" + storage.get(0)+"仓库还剩："+ storage.size());
        storage.remove(0);*/
        //等价代码：
        System.out.println(name+" 拿到了" + storage.poll()+"仓库还剩："+ storage.size());
        notify();
    }
}