package design_patterns_2.struct.adapter.jvobject;

/**
 * 对象适配器模式： 适配不满足指定场景的类，以符合使用要求
 * 可以适配多个个对象
 * */
public class AdapterObjTest {

    public static void main(String[] args) {
        Jack2 jack2 = new Jack2();
        AdapterObject adapter = new AdapterObject(jack2);
        JackJiao jackJiao = new JackJiao();

        System.out.println("笔记本只可用2孔插座：");
        adapter.convert(2);
        adapter.use();
    }
}
