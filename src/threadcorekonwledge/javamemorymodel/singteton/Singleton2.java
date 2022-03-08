package threadcorekonwledge.javamemorymodel.singteton;
/**
* 饿汉式（静态代码块）可用
 * 跟Singleton1没有区别
* */
public class Singleton2 {
    private final static  Singleton2 INSTANCE;

    private Singleton2(){

    }

    static {
        INSTANCE = new Singleton2();
    }

    public static Singleton2 getINSTANCE() {
        return INSTANCE;
    }
}
