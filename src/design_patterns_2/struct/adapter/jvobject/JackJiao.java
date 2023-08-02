package design_patterns_2.struct.adapter.jvobject;
/**
 * 现有类 交流电
 */
public class JackJiao implements IJack{
    private boolean isJiao = true;

    public void info(){
        System.out.println(isJiao?"交流电":"直流电");
    }
}
