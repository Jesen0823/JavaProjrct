package design_patterns_2.create.factoryfunction;
/*工厂方法模式 用于复杂对象的创建 */
public class TestFactoryFunction {

    public static void main(String[] args) {
        // 1. 一种产品一个工厂
        Factory factory = new TeaFactory();
        ProductCup p = factory.createProduct();
        p.put();

        //2. 直接用一个工厂，反射动态创建所需产品
        Factory2 factory2 = new ConcreteFactory();
        ProductCup p2 = factory2.createProduct(CoffeeCup.class);
        p2.put();
    }
}
