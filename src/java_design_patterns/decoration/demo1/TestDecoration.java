package java_design_patterns.decoration.demo1;

/**
 * 装饰模式
 *
 * ·使用场景：
 * 在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
 * 需要动态地给一个对象增加功能，这些功能可以动态地撤销。当不能采用继承的方式对系统进行扩充或者采用继承不利于系统扩展和维护时。
 *
 * ・优点：
 * 通过组合而非继承的方式，动态地扩展一个对象的功能，在运行时选择不同的装饰器，从而实现不同的行为。
 * 有效避免了使用继承的方式扩展对象功能而带来的灵活性差、子类无限制扩张的问题。
 * 具体组件类与具体装饰类可以独立变化，用户可以根据需要增加新的具体组件类和具体装饰类，在使用时再对其进行组合，原有代码无须改变，符合“开放封闭原则”。
 *
 * ・缺点：
 * 因为所有对象均继承于Component，所以如果Component内部结构发生改变，则不可避免地影响所有子类（装饰者和被装饰者）。如果基类改变，则势必影响对象的内部。
 * 比继承更加灵活机动的特性，也同时意味着装饰模式比继承更加易于出错，排错也很困难。对于多次装饰的对象，调试时寻找错误可能需要逐级排查，较为烦琐。所以，只在必要的时候使用装饰模式。
 * 装饰层数不能过多，否则会影响效率。
 *
 * */
public class TestDecoration {

    public static void main(String[] args) {
        Cannon7600 cannon7600 = new Cannon7600();

        System.out.println("【未扩展功能以前:】");
        cannon7600.print();

        System.out.println("【升级扩展功能之后:】");
        DecoretePrinterX decoretePrinterX = new DecoretePrinterX(cannon7600);
        decoretePrinterX.print();
        DecoretePrinterXX decoretePrinterXX = new DecoretePrinterXX(cannon7600);
        decoretePrinterXX.print();
    }
}
