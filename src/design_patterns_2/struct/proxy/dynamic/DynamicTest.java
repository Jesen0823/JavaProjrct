package design_patterns_2.struct.proxy.dynamic;

import design_patterns_2.struct.proxy.statics.Coder;
import design_patterns_2.struct.proxy.statics.ILawsuit;

import java.lang.reflect.Proxy;

public class DynamicTest {
    public static void main(String[] args) {
        ILawsuit worker = new Coder("小勇");
        DynamicProxy proxy = new DynamicProxy(worker);

        ClassLoader classLoader = worker.getClass().getClassLoader();

        // 代理律师
        ILawsuit lawyer = (ILawsuit) Proxy.newProxyInstance(classLoader,new Class[]{ILawsuit.class},proxy);
        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();
    }
}
