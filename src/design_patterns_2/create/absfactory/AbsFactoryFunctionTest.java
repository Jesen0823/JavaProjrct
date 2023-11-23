package design_patterns_2.create.absfactory;
/**
 * 抽象工厂方法模式  类比较多，Android用到的地方不多
 * 用于复杂场景，比如昼夜主题
 * */
public class AbsFactoryFunctionTest {

    public static void main(String[] args) {
        PhoneFactory factory = new VivoFactory();
        factory.createCamera().camera();
        factory.createCPU().coreCpu();
        factory.createScreen().screen();
    }
}
