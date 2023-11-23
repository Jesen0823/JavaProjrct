package design_patterns_2.struct.facade;
/**
 * 外观模式/门面模式
 * 统一接口的封装，隐藏掉子系统的交互和逻辑，给用户提供一个高层次的接口，使系统更加易用
 * 暴露最少细节，符合迪米特法则
 * ContextImpl就是外观模式，屏蔽了细节，保证系统易用性稳定性
 */
public class FacadeTest {

    public static void main(String[] args) {
        MobilePhone xiaomi = new MobilePhone();
        xiaomi.talk();
        xiaomi.videoChat();
        xiaomi.takePicture();
    }
}
