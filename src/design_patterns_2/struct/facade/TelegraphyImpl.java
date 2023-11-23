package design_patterns_2.struct.facade;

public class TelegraphyImpl implements Telegraphy{
    @Override
    public void dail() {
        System.out.println("拨号--打电话");
    }

    @Override
    public void hangup() {
        System.out.println("挂断");
    }
}
