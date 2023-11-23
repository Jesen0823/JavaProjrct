package design_patterns_2.struct.bridge;
/**
 * 桥接模式
 * 将抽象部分与实现部分分离，使他们都可以独立变化
 * 如果一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性
 * 避免在两个层次之间建立静态的继承关系，可以通过桥接模式使他们在抽象层建立一个联系
 *
 * 咖啡的大小杯，口味，两个维度，没有过多交集，
 * 唯一联系是Coffee保持了CoffeeAdditives的引用，这就是纽带，这就是桥接
 *
 * 源码中Button，TextView，View就是桥接
 * Window，WindowManagerGlobal,WindowManager就是桥接
 *
 * 实际应用中，对抽象与实现的把握，需不需要分离，如何分离？不太好把握
 */
public class BridgeTest {

    public static void main(String[] args) {
        Sugar sugar = new Sugar();
        Ordinary ordinary = new Ordinary();

        LargeCupCoffee largeSugar = new LargeCupCoffee(sugar);
        largeSugar.makeCoffee();
        LargeCupCoffee largeOrdinary = new LargeCupCoffee(ordinary);
        largeOrdinary.makeCoffee();

        SmallCupCoffee smallSugar = new SmallCupCoffee(sugar);
        smallSugar.makeCoffee();
        SmallCupCoffee smallOrdinary = new SmallCupCoffee(ordinary);
        smallOrdinary.makeCoffee();
    }
}
