package java_design_patterns.proxy.statics;

/**
 * 静态代理模式：
 *
 * */
public class TestStaticProxy {

    public static void main(String[] args) {
        IShop consumer = new Cousmer();
        IShop proxy = new ShanSongProxy(consumer);
        proxy.buy();
    }
}
