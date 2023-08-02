package design_patterns_2.create.singlton;
/**
 * Java 静态内部类  线程安全
 * */
public class SingletonStaticInner {

    private SingletonStaticInner(){

    }

    public static SingletonStaticInner getInstance(){
        return SingletonStaticInnerProvider.get();
    }

    private static class SingletonStaticInnerProvider{
        private static final SingletonStaticInner instance = new SingletonStaticInner();

        protected static SingletonStaticInner get(){
            return instance;
        }
    }
}
