package design_patterns_2.create.absfactory;

public class HigheCamera implements ICamera{
    @Override
    public void camera() {
        System.out.println("高像素相机");
    }
}
