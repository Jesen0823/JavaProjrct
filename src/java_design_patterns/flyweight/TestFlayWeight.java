package java_design_patterns.flyweight;

/**
 * 享元模式
 *
 * 享元模式是池技术的重要实现方式，它可以减少应用程序创建的对象，降低程序内存的占用，提高程序的性能。
 *
 * 定义：使用共享对象有效地支持大量细粒度的对象要求细粒度对象，那么不可避免地使得对象数量多且性质相近。这些对象分为两个部分：内部状态和外部状态。
 * 内部状态是对象可共享出来的信息，存储在享元对象内部并且不会随环境的改变而改变；而外部状态是对象依赖的一个标记，它是随环境改变而改变的并且不可共享的状态。
 *
 * 2.享元模式的使用场景
 * ·系统中存在大量的相似对象。
 * ·需要缓冲池的场景。
 * */
public class TestFlayWeight {

    public static void main(String[] args) {
        Goods goods1 = GoodsFactory.getGoods("UNIQLO");
        goods1.showPrice("0");

        Goods goods2 = GoodsFactory.getGoods("UNIQLO");
        goods1.showPrice("0");

        Goods goods3 = GoodsFactory.getGoods("UNIQLO");
        goods1.showPrice("1");

        Goods goods4 = GoodsFactory.getGoods("ANTA");
        goods1.showPrice("1");

        Goods goods5 = GoodsFactory.getGoods("ANTA");
        goods1.showPrice("0");

        System.out.println("goods1: "+goods1);
        System.out.println("goods2: "+goods2);
        System.out.println("goods3: "+goods3);
        System.out.println("goods4: "+goods4);
        System.out.println("goods5: "+goods5);

        /* 打印结果：
        goods1: java_design_patterns.flyweight.Goods@74a14482
        goods2: java_design_patterns.flyweight.Goods@74a14482
        goods3: java_design_patterns.flyweight.Goods@74a14482
        goods4: java_design_patterns.flyweight.Goods@1540e19d
        goods5: java_design_patterns.flyweight.Goods@1540e19d
        */
    }
}
