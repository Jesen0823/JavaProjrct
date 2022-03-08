package threadcorekonwledge.javamemorymodel.singteton;
/**
 * 饿汉式（静态常量）可用
 * 类装载的时候就初始化了
 * */
public class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){

    }

    public  static Singleton1 getInstance() {
        return INSTANCE;
    }
}
