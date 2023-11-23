package design_patterns_2.create.factoryfunction;

public class CoffeeFactory extends Factory{

    @Override
    public ProductCup createProduct() {
        return new CoffeeCup();
    }
}
