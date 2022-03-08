package threadcorekonwledge.synchronized1.synchronized_texing;
/**
 * 可重入粒度测试：递归调用本方法
 * */
public class SynchronizedRecursion1 {
    int a = 0;

    public static void main(String[] args) {
        SynchronizedRecursion1 synchronizedRecursion1 = new SynchronizedRecursion1();
        synchronizedRecursion1.method1();
    }

    private synchronized void method1() {
        System.out.println("method1...a="+a);
        if (a == 0){
            a++;
            method1();
        }
    }
}
