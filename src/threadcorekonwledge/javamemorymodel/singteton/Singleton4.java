package threadcorekonwledge.javamemorymodel.singteton;
/**
 * 懒汉式（线程安全） 不推荐用
 * 与Singleton3 相比多了个synchronized，保证了线程同步；但是synchronized会等待，效率低
 * */
public class Singleton4 {
    private static Singleton4 INSTANCE;

    private Singleton4(){

    }

    public synchronized static Singleton4 getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new Singleton4();
        }
        return INSTANCE;
    }
}
