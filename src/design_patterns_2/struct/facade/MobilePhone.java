package design_patterns_2.struct.facade;

public class MobilePhone {
    private Telegraphy telegraphy = new TelegraphyImpl();
    private Camera camera = new CameraImpl();

    public void talk(){
        telegraphy.dail();
        System.out.println("......通话中.....");
        telegraphy.hangup();
    }

    public void videoChat(){
        camera.open();
        telegraphy.dail();
        System.out.println("......视频中.....");
        telegraphy.hangup();
        camera.close();
    }

    public void takePicture(){
        camera.open();
        camera.takePicture();
        camera.close();
    }
}
