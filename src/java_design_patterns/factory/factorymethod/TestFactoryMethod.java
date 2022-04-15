package java_design_patterns.factory.factorymethod;

public class TestFactoryMethod {

    public static void main(String[] args) {
        PhoneFactory phoneFactory = new CommonFactory();

        HuaweiPhone huaweiPhone = phoneFactory.createPhone(HuaweiPhone.class);
        ApplePhone applePhone = phoneFactory.createPhone(ApplePhone.class);

        huaweiPhone.boot();
        applePhone.boot();
    }
}
