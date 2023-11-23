package design_patterns_2.create.absfactory;

public abstract class PhoneFactory {

    public abstract IScreen createScreen();

    public abstract ICpu createCPU();

    public abstract ICamera createCamera();
}
