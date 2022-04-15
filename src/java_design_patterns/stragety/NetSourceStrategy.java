package java_design_patterns.stragety;

public class NetSourceStrategy implements PlayStrategy {
    @Override
    public void playVideo() {
        System.out.println("播放网络视频，添加预加载，字幕");
    }
}
