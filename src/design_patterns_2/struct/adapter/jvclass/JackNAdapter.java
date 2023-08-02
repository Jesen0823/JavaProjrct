package design_patterns_2.struct.adapter.jvclass;

public class JackNAdapter extends Jack3 implements ConvertTarget {

    @Override
    public int convert(int num) {
        n = 2;
        System.out.println("插入转换器 转换目标： "+num+"孔电源");
        return num;
    }
}
