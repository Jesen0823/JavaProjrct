package design_patterns_2.create.factoryfunction;

public class TeaFactory extends Factory{

    @Override
    public ProductCup createProduct() {
        return new TeaCup();
    }

}
