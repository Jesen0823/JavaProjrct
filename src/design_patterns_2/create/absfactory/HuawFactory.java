package design_patterns_2.create.absfactory;

public class HuawFactory extends PhoneFactory{
    @Override
    public IScreen createScreen() {
        return new BoliScreen();
    }

    @Override
    public ICpu createCPU() {
        return new QilinCpu();
    }

    @Override
    public ICamera createCamera() {
        return new MediumCamera();
    }
}
