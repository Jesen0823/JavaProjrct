package java_design_patterns.facade;

/**
 * 子系统2 操作或行为
 */
public class SubBehavior {

    public void playMusic(){
        System.out.println("行为- 播放音乐");
    }

    public void playVip(){
        System.out.println("行为- 播放会员片");
    }

    public void playSingleBuy(){
        System.out.println("行为- 播放订购片");
    }
}
