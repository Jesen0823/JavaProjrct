package design_patterns_2.struct.adapter.jvobject;

public class AdapterObject implements Target {
    private Jack2 origin;

    public AdapterObject(Jack2 jack2){
        this.origin = jack2;
    }

    @Override
    public int convert(int num) {
        System.out.println("转换为"+num+"孔");
        return num;
    }

    @Override
    public void use() {
        origin.insertUse();
    }
}
