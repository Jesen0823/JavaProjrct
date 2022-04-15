package java_design_patterns.builder;

public class Phone {

    private int memory;
    private String cpu;
    private int screenSize;

    public int getMemory() {
        return memory;
    }

    public String getCpu() {
        return cpu;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "手机{\n" +
                "内存:" + memory + "GB\n" +
                "cpu:" + cpu + "\n " +
                "屏幕大小：" + screenSize + "英寸\n}" ;
    }
}
