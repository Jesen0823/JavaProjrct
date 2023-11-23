package design_patterns_2.create.factoryfunction;

/* 工厂方法模式 抽象工厂*/
public abstract class Factory2 {

    // 方式2：通过反射生成对象
    public abstract <T extends ProductCup> T createProduct(Class<T> clz);
}
