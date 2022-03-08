package threadcorekonwledge.javamemorymodel;
/**
 * 可见性问题
 * 用volatile修复
 * */
public class FieldVisibilityFixed2 {
    volatile int a = 1;
    volatile int b = 2;
    /**近朱者赤：给b加volatile而a不加也行，这一个volatile不仅影响b,而且能实现轻量级同步
     * b之前的写入靠的是a,而b的写入操作对后面b的读取是可见的，这就是happens-before原则的体现
     * */

    public static void main(String[] args) {
        while (true) {
            FieldVisibilityFixed2 instance = new FieldVisibilityFixed2();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance.change();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance.print();
                }
            }).start();
        }
    }

    private void change() {
        a = 3;
        b = a;
    }

    private void print(){
        System.out.println("a="+a+",b="+b);
    }
}
