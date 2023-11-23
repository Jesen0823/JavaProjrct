package java_design_patterns.decoration.demo2;

/**
 * 修饰Boy类，在不破坏Boy的前提下扩展其功能
 */
public class WinterCloth extends PersonCloth {

    public WinterCloth(Person person) {
        super(person);
    }

    private void dressShirt(){
        System.out.println("穿衬衫");
    }

    private void dressLeather(){
        System.out.println("穿皮衣");
    }
    private void dressOuter(){
        System.out.println("穿羽绒服");
    }

    private void dressInner(){
        System.out.println("贴膏药");
    }

    @Override
    public void dress() {
        dressInner();
        super.dress();
        dressShirt();
        dressLeather();
        dressOuter();

    }
}
