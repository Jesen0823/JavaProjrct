package design_patterns_2.struct.proxy.statics;
/**
 * 代理模式接口
 * */
public interface ILawsuit {

    String getName();

    // 提交申请
    void submit();

    // 进行举证
    void burden();

    // 开始辩护
    void defend();

    // 诉讼完成
    void finish();
}
