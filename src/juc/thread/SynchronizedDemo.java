package juc.thread;

public class SynchronizedDemo {

    Object o = new Object();

    public static void main(String[] args) {
    }

    public void m1() {
        synchronized (o) {
            System.out.println("-------m1");
        }
    }

}
