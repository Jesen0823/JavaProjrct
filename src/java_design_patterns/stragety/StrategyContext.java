package java_design_patterns.stragety;

/**
 * 上下文 构造方法包含策略类 管理不同的策略
 * */
public class StrategyContext {

    private PlayStrategy strategy;

    public StrategyContext(PlayStrategy strategy){
        this.strategy = strategy;
    }

    public void play(){
        strategy.playVideo();
    }
}
