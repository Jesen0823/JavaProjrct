package design_patterns_2.struct.adapter.jvclass;
/**
 * 需要适配的接口
 * 转换以满足特殊场景
 * 插线板
 * */
public interface ConvertTarget {
    int convert(int num);
}
