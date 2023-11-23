package design_patterns_2.create.absfactory;

public class QilinCpu implements ICpu {
    @Override
    public void coreCpu() {
        System.out.println("麒麟CPU");
    }
}
