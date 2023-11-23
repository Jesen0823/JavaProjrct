package design_patterns_2.action.stragety;
/**
 * 策略模式主要用来分离算法
 * 在相同的行为抽象下，有不同的具体实现策略
 * 开闭原则，定义抽象，注入不同的实现，提高扩展性
 * */
public class StrategyTest {

    public static void main(String[] args) {
        Annimotation annimotation = new Annimotation();
        InterpolatorStrategy strategy = new AccelerateInterpolator();
        annimotation.setStrategy(strategy);
        annimotation.start();
    }
}
