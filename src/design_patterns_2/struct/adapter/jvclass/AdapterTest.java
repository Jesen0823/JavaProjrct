package design_patterns_2.struct.adapter.jvclass;
/**
 * 类适配器模式： 适配不满足指定场景的类，以符合使用要求
 * 3孔插电源适配为2孔
 * 类适配器模式： java继承局限性，只能适配一个类，不能适配多个类或者该类的子类
 * */
public class AdapterTest {

    public static void main(String[] args) {
        JackNAdapter adapter = new JackNAdapter();
        System.out.println("笔记本只可用2孔插座：");
        adapter.convert(2);
        adapter.insertUse();
    }
}
