package design_patterns_2.create.singlton;
/**
 * Java 饿汉模式
 */
public class EHanSingleton {

    private final static EHanSingleton instance = new EHanSingleton();

    public static EHanSingleton getInstance(){
        return instance;
    }

    private EHanSingleton(){

    }
}
