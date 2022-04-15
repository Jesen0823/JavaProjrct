package java_design_patterns.templatemethod;

public class QrCodeSweep extends SweepCode {
    @Override
    protected void getCaptureImage() {
        System.out.println("获取二维码图像");
    }

    @Override
    protected void decodeData() {
        System.out.println("解码二维码图像");
    }

    @Override
    protected void extendFunction() {
        System.out.println("如果拿到扫码结果是URL，直接跳转浏览器");
    }
}
