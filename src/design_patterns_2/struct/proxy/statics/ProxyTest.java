package design_patterns_2.struct.proxy.statics;

/**
 * 代理模式 委托模式
 * 当无法或不想直接访问某个对象或访问某个对象存在困难时可以通过一个代理对象来间接访
 * 问，为了保证客户端使用的透明性，委托对象与代理对象需要实现相同的接口。
 * */
public class ProxyTest {
    public static void main(String[] args) {
        ILawsuit coder = new Coder("小敏");
        ILawsuit lawyer = new Lawyer(coder,"兰州中胜律师事务所");

        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();
    }
}
