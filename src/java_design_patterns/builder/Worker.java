package java_design_patterns.builder;

/**
 * 车间工人根据工艺流程生产手机
 * */
public class Worker {

    AbsBuilder builder = null;

    public Worker(AbsBuilder builder) {
        this.builder = builder;
    }

    public Phone createPhone(int memory, String cpu, int screenSize){
        this.builder.buildMemory(memory);
        this.builder.buildCpu(cpu);
        this.builder.buildSize(screenSize);

        return builder.create();
    }
}
