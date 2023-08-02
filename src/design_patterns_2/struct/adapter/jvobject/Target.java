package design_patterns_2.struct.adapter.jvobject;
/**
 * 需要适配的接口
 * 转换以满足特殊场景
 * 插线板
 * */
public interface Target {
    int convert(int num);

    void use();
}
