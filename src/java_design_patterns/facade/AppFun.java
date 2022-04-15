package java_design_patterns.facade;

/**
 * 外观类  提供了内部系统的封装，提供外部调用的入口
 * */
public class AppFun {

    private SubUser subUser;
    private SubBehavior subBehavior;
    private SubAudio subAudio;

    public AppFun() {
        subUser = new SubUser();
        subBehavior = new SubBehavior();
        subAudio = new SubAudio();
    }

    /**
     * 播放腾讯片源
     */
    public void playTencentVideo() {
        // 首先需要登录
        subUser.login();
        // 开通会员
        subUser.openVip();
        // 播放会员片
        subBehavior.playVip();
    }

    public void playBuyVideo() {
        subUser.login();
        subUser.pay();
        subBehavior.playSingleBuy();
    }

    public void playMusic() {
        subAudio.audioUp();
        subBehavior.playMusic();
    }
}
