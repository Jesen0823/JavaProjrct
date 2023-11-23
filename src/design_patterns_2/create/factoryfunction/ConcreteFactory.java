package design_patterns_2.create.factoryfunction;

public class ConcreteFactory extends Factory2{

    @Override
    public <T extends ProductCup> T createProduct(Class<T> clz) {
        ProductCup p = null;
        try {
            p = (ProductCup) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)p;
    }
}
