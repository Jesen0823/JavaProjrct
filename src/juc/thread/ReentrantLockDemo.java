package juc.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock + Condition的 生产者消费者
 */
public class ReentrantLockDemo {
    ReentrantLock lock = new ReentrantLock(true);
    Condition condition1;
    Condition condition2;

    public ReentrantLockDemo(){
       condition1 = lock.newCondition();
       condition2 = lock.newCondition();
    }

    class Worker implements Runnable{
        private int id;

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            if (id == 1){
                try {
                    condition2.await();
                    Thread.sleep(1000);
                    System.out.println("A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    
                }
            }else {

            }
        }
    }
}
