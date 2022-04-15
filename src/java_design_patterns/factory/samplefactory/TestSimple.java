package java_design_patterns.factory.samplefactory;

/**
 * 简单工厂模式： 违背了开放封闭原则
 *
 * ·[优点]：使用户根据参数获得对应的类实例，避免了直接实例化类，
 * 降低了耦合性。
 *
 * ·[缺点]：可实例化的类型在编译期间已经被确定。如果增加新类型，
 * 则需要修改工厂，这违背了开放封闭原则。简单工厂需要知道所有要生成
 * 的类型，其当子类过多或者子类层次过多时不适合使用。
 *
 * */
public class TestSimple {

    public static void main(String[] args) {
        Phone phone = PhoneFactory.createPhone("xiaomi");
    }
}
