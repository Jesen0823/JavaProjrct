package java_design_patterns.stragety;

/**
 * 策略模式
 *
 * 定义：定义一系列的算法，把每一个算法封装起来，并且使它们可相互替换。策略模式使得算法可独立于使用它的客户而独立变化。
 * 解决条件嵌套问题
 *
 * ・优点：
 * 使用策略模式可以避免使用多重条件语句。多重条件语句不易维护，
 * 而且易出错。易于拓展。当需要添加一个策略时，只需要实现接口就可以了。
 *
 * ・缺点：
 * 每一个策略都是一个类，复用性小。如果策略过多，类的数量会增
 * 多。上层模块必须知道有哪些策略，才能够使用这些策略，这与迪米特原则相违背。
 * */
public class StrategyTest {
    public static void main(String[] args) {
        StrategyContext context;

        context = new StrategyContext(new LocalSourceStrategy());
        context.play();

        context = new StrategyContext(new NetSourceStrategy());
        context.play();

        context = new StrategyContext(new LiveSourceStrategy());
        context.play();
    }
}
