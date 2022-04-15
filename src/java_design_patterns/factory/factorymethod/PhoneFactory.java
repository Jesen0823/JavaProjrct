package java_design_patterns.factory.factorymethod;

public abstract class PhoneFactory {

    public abstract <T extends Phone> T createPhone(Class<T> clazz);
}
