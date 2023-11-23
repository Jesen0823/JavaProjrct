package design_patterns_2.struct.facade;

public class CameraImpl implements Camera{
    @Override
    public void open() {
        System.out.println("打开相机");
    }

    @Override
    public void takePicture() {
        System.out.println("相机拍摄");
    }

    @Override
    public void close() {
        System.out.println("相机关闭");
    }
}
