package java_design_patterns.builder;

/**
 * 手机产品工艺流程
 * */
public class RealBuilder extends AbsBuilder {
    private Phone mPhone = new Phone();

    @Override
    public void buildMemory(int memory) {
        mPhone.setMemory(memory);
    }

    @Override
    public void buildCpu(String cpu) {
        mPhone.setCpu(cpu);
    }

    @Override
    public void buildSize(int screenSize) {
        mPhone.setScreenSize(screenSize);
    }

    @Override
    public Phone create() {
        return mPhone;
    }
}
