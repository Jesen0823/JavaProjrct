package design_patterns_2.create.singlton;
/**
 * Java懒汉式  线程安全 并发效率低
 * */
public class LazySingletonSafe {

    private static LazySingletonSafe instance;

    private LazySingletonSafe(){

    }

    public static synchronized LazySingletonSafe getInstance(){
        if (instance == null){
            instance = new LazySingletonSafe();
        }
        return instance;
    }
}
