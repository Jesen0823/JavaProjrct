package java_design_patterns.templatemethod;

/**
 * 定义抽象类 定义扫码框架
 * */
public abstract class SweepCode {

    // 二维码识别
    public final void sweep(){
        // 检查相机权限
        checkCameraPermission();
        // 打开相机
        openCamera();
        // 获取数据帧
        getCaptureImage();
        // 解码图片
        decodeData();

        // 返回结果
        extendFunction();
    }

    protected final boolean checkCameraPermission(){
        System.out.println("检查相机权限");
        return true;
    }

    protected final void openCamera(){
        System.out.println("打开相机");
    }

    // 待子类去实现
    protected abstract void getCaptureImage();
    protected abstract void decodeData();

    // 空实现方法，由子类决定是否覆写
    protected void extendFunction(){
    }

}
