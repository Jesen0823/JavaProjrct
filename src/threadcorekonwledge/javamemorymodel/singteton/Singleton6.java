package threadcorekonwledge.javamemorymodel.singteton;
/**
 * 双重检查 （推荐面试使用）线程安全，延迟加载，效率高
 * double-check为什么要volatile?
 * 因为创建对象是分三部进行的，不是一个原子操作，有可能重排序导致跳过判空，但对象还没初始化完，拿到一个空属性的结果
 * */
public class Singleton6 {
    private volatile static Singleton6 INSTANCE;

    private Singleton6(){

    }

    public static Singleton6 getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (Singleton6.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton6();
                }
            }
        }
        return INSTANCE;
    }
}
