package design_patterns_2.struct.proxy.dynamicproxy;
/**
 * 定义真实主题实现，该主题的对象可用直接传入代理的bind
 * */
public class RealSubject implements Subject{
    @Override
    public String myMethod(String name, int altitude) {
        return "There are "+name+" and is's altitude is "+ altitude+"m";
    }
}
