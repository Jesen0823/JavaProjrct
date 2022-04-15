package java_design_patterns.templatemethod;

/**
 * 条形码识别
 * */
public class BarCodeSweep extends SweepCode{

    @Override
    protected void getCaptureImage() {
        System.out.println("获取条形码图像");
    }

    @Override
    protected void decodeData() {
        System.out.println("解码条形码图像");
    }
}
