package threadcorekonwledge.deadlock;
/**
 * 哲学家就餐问题
 * */
public class DiningPhilosophers5 {

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] chopsticks = new Object[philosophers.length];
        // 初始化筷子
        for (int i = 0; i < chopsticks.length; i++){
            chopsticks[i] = new Object();
        }
        // 初始化哲学家
        for (int i = 0; i < philosophers.length; i++){
            Object left = chopsticks[i];
            Object right = chopsticks[(i+1) % chopsticks.length];
            philosophers[i] = new Philosopher(left, right);

            new Thread(philosophers[i],"哲学家"+(i+1)).start();
        }
    }

    public static class Philosopher implements Runnable{
        private Object leftChopstick;
        private Object rightChopstick;

        public Philosopher(Object leftChopstick, Object rightChopstick) {
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
        }

        @Override
        public void run() {
            try {
                while (true) {

                    doAction("Thinking.");

                    synchronized (leftChopstick) {
                        doAction("Picked up left chopstick.");
                        synchronized (rightChopstick) {
                            doAction("Picked up right chopstick.");
                            doAction("Put down right chopstick.");
                        }
                        doAction("Put down left chopstick.");
                    }

                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void doAction(String action) throws InterruptedException {
            System.out.println(Thread.currentThread().getName()+":"+action);
            Thread.sleep((long) (Math.random() * 10));
        }
    }

}
