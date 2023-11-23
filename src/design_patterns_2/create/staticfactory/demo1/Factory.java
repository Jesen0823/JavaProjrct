package design_patterns_2.create.staticfactory.demo1;

/**
 * 简单工厂，静态工厂，工厂类只有一个
 * 静态方法工厂模式
 * */
public abstract class Factory {

    public static Product createProduct(){
        return new ConcreteProduct();
    }
}
