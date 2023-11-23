package design_patterns_2.create.absfactory;

public class VivoFactory extends PhoneFactory {
    @Override
    public IScreen createScreen() {
        return new IDLScreen();
    }

    @Override
    public ICpu createCPU() {
        return new XiaolongCpu();
    }

    @Override
    public ICamera createCamera() {
        return new HigheCamera();
    }
}
