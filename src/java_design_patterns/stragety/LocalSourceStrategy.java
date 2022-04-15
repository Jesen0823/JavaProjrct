package java_design_patterns.stragety;

public class LocalSourceStrategy implements PlayStrategy {

    @Override
    public void playVideo() {
        System.out.println("播放本地资源，直接全屏");
    }
}
