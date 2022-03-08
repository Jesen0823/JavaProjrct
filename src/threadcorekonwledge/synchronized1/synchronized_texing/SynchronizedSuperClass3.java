package threadcorekonwledge.synchronized1.synchronized_texing;
/**
 * 可重入粒度测试3：调用父类的方法（证明与类无关）
 *
 * */
public class SynchronizedSuperClass3 {
    public synchronized void doSomething(){
        System.out.println("父类方法 doSomething...");
    }
}

class ChildClass extends SynchronizedSuperClass3{
    @Override
    public synchronized void doSomething() {
        System.out.println("子类方法 doSomething...");
        super.doSomething();
    }

    public static void main(String[] args) {
        ChildClass child = new ChildClass();
        child.doSomething();
    }
}
