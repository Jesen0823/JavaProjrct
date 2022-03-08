package threadcorekonwledge.javamemorymodel.singteton;
/**
 * 懒汉式（线程不安全） 不推荐用
 * 与Singleton4相比会建多个对象
 * */
public class Singleton5 {
    private static Singleton5 INSTANCE;

    private Singleton5(){

    }

    public static Singleton5 getINSTANCE() {
        if (INSTANCE == null){
            synchronized(Singleton5.class){
                INSTANCE = new Singleton5();
            }
        }
        return INSTANCE;
    }
}
