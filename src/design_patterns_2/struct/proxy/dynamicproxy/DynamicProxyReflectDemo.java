package design_patterns_2.struct.proxy.dynamicproxy;
/**
 * 测试动态代理
 * */
public class DynamicProxyReflectDemo {
    public static void main(String[] args) {
        MyInvocationHandler handler = new MyInvocationHandler();
        Subject subject = (Subject) handler.bind(new RealSubject());
        String info = subject.myMethod("乔戈里峰",8611);
        System.out.println(info);
    }
}
