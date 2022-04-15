package java_design_patterns.facade;

/**
 * 子系统3 音量设置
 * */
public class SubAudio {

    public void audioUp(){
        System.out.println("音量- 增大");
    }

    public void audioMutex(){
        System.out.println("音量- 静音");
    }
}
