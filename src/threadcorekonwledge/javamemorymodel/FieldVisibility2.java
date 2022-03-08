package threadcorekonwledge.javamemorymodel;
/**
 * 可见性问题
 * 打印线程看到了一半的线程1的修改 a=1 b=3
 * */
public class FieldVisibility2 {
    int a = 1;
    int b = 2;

    public static void main(String[] args) {
        while (true) {
            FieldVisibility2 instance = new FieldVisibility2();

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
