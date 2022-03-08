package threadcorekonwledge.synchronized1.synchronized_texing;
/**
 * 可重入粒度测试二：调用类内部另外的方法
 *
 * */
public class SynchornizedOtherMethod2 {

    public static void main(String[] args) {
        SynchornizedOtherMethod2 instance = new SynchornizedOtherMethod2();
        instance.method1();
    }

    public synchronized void method1(){
        System.out.println("method1...");
        method2();
    }

    private synchronized void method2() {
        System.out.println("method2...");
    }
}
