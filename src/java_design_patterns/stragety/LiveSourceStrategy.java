package java_design_patterns.stragety;

public class LiveSourceStrategy implements PlayStrategy {
    @Override
    public void playVideo() {
        System.out.println("播放直播资源");
    }
}
