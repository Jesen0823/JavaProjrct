package java_design_patterns.decoration.demo2;
/**
 * 装饰者模式
 * 在不破坏原有类的结构下，扩展其功能，具有高度的灵活性
 * Context，ContextImpl,ContextWrap就是典型装饰者模式
 */
public class DecorTest {
    public static void main(String[] args) {
        Person person = new Boy();
        person.dress();

        System.out.println("太冷了，重新穿");

        PersonCloth winterCloth = new WinterCloth(person);
        winterCloth.dress();
    }
}
