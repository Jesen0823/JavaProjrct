package design_patterns_2.struct.adapter.jvobject;

/**
 * 现有类，待适配
 * 3孔式插孔，只能插三孔型插头
 */
public class Jack2 implements IJack{
    int n = 3;

    public Jack2(){
        System.out.println("原装：只有3孔电源");
    }

    public void insertUse() {
        System.out.println("插入取电：" + n+"孔电源");
    }
}
