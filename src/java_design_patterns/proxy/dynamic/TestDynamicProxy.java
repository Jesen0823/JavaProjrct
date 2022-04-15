package java_design_patterns.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 代理模式优点：
 * 真实主题类随时都会发生变化；但是因为它实现了公共的接口，所以代理类可以不做任何修改就能够使用。
 *
 * 静态代理，在代码运行前就已经存在了代理类的class编译文件
 *
 * 而动态代理则是在代码运行时通过反射来动态地生成代理类的对象，并确定到底来代理谁。也就是我们在编码阶段无须知道代理谁，代理谁将会在代码运
 * 行时决定。
 * Java提供了动态的代理接口InvocationHandler,实现该接口需要重写invoke（）方法。
 * */
public class TestDynamicProxy {

    public static void main(String[] args) {
        IShop consumer = new Consumer();
        // 创建动态代理
        DynamicAdagent dynamicAdagent = new DynamicAdagent(consumer);
        ClassLoader loader = consumer.getClass().getClassLoader();
        // 创建动态代理类
        IShop proxy = (IShop) Proxy.newProxyInstance(loader,new Class[]{IShop.class},dynamicAdagent);
        proxy.buy();
    }
}
