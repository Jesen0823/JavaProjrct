package design_patterns_2.create.staticfactory.demo1;

public class ConcreteProduct extends Product {

    @Override
    public void use() {
        System.out.println("我是具体产品");
    }
}
