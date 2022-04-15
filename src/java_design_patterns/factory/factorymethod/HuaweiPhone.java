package java_design_patterns.factory.factorymethod;

public class HuaweiPhone extends Phone {
    @Override
    public void boot() {
        System.out.println("华为手机启动");
    }
}
