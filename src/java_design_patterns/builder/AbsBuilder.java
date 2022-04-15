package java_design_patterns.builder;

/**
 * 手机产品设计图
 * */
public abstract class AbsBuilder {

    public abstract void buildMemory(int memory);
    public abstract void buildCpu(String cpu);
    public abstract void buildSize(int screenSize);

    public abstract Phone create();
}
