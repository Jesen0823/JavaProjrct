package design_patterns_2.struct.proxy.statics;

public class Coder implements ILawsuit{

    private String name;

    public Coder(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void submit() {
        System.out.println(name+": 老板拖欠工资，申请仲裁");
    }

    @Override
    public void burden() {
        System.out.println(name+": 举证材料：劳动合同");
    }

    @Override
    public void defend() {
        System.out.println(name+": 辩护有力，证据确凿");
    }

    @Override
    public void finish() {
        System.out.println(name+": 诉讼生效，被告履行义务");
    }
}
