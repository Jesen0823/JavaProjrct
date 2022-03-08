package javabasereview.reflect.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 定义InvocationHandler的子类，完成动态代理的具体操作
 * */
public class MyInvocationHandler implements InvocationHandler {
    private Object obj; // 真实主题
    // 绑定真实主题操作，传入被代理对象的真实主题实现
    public Object bind(Object o){
        this.obj = o;
        return Proxy.newProxyInstance(o.getClass().getClassLoader()
                ,o.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 传入真实主题和参数
        Object temp = method.invoke(this.obj, args);
        return temp;
    }
}
