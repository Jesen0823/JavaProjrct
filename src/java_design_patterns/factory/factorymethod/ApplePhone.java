package java_design_patterns.factory.factorymethod;

public class ApplePhone extends Phone {
    @Override
    public void boot() {
        System.out.println("苹果手机启动");
    }
}
